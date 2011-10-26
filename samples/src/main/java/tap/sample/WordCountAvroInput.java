package tap.sample;

import java.util.StringTokenizer;

import org.apache.avro.mapred.AvroJob;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import tap.core.*;

public class WordCountAvroInput extends Configured implements Tool {

    @Override
    public int run(String[] args) throws Exception {

        /* Set up a basic pipeline of map reduce */
        Assembly wordcount = new Assembly(getClass()).named("wordcount");
        /* Parse options - just use the standard options - input and output location, time window, etc. */
        BaseOptions o = new BaseOptions();
        int result = o.parse(wordcount, args);
        if (result != 0)
            return result;
        if (o.input == null) {
            System.err.println("Must specify input directory");
            return 1;
        }
        if (o.output == null) {
            System.err.println("Must specify output directory");
            return 1;
        }


        Pipe<CountRec> input = Pipe.of(CountRec.class).at(o.input);
        Pipe<CountRec> counts = new Pipe<CountRec>(o.output);
        wordcount.produces(counts);
        
        Phase count = new Phase().reads(input).writes(counts).map(Mapper.class).
            groupBy("word").reduce(Reducer.class);
        
        
        if (o.forceRebuild) wordcount.forceRebuild();
        if (o.dryRun) {
            wordcount.dryRun();
            return 0;
        }
        
        wordcount.execute();
        
        return 0;
    }

    public static class CountRec {
        public String word;
        public int count;
    }
    

    public static class Mapper extends BaseMapper<CountRec,CountRec> {
        @Override
        public void map(CountRec in, CountRec out, TapContext<CountRec> context) {
            context.write(in);
        }        
    }

    public static class Reducer extends BaseReducer<CountRec,CountRec> {

        @Override
        public void reduce(Iterable<CountRec> in, CountRec out, TapContext<CountRec> context) {
            out.count = 0;
            for (CountRec rec : in) {
                out.word = rec.word;
                out.count += rec.count;
            }
            context.write(out);
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new WordCountAvroInput(), args);
        System.exit(res);
    }

}