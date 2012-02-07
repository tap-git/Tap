/*
 * Licensed to Think Big Analytics, Inc. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Think Big Analytics, Inc. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Copyright 2011 Think Big Analytics. All Rights Reserved.
 */
package tap;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tap.Phase;
import tap.Pipe;
import tap.core.PipePlan;


public class PipePlanTests {
    private PipePlan plan;
    private Phase p1, p2, p3;
    private Pipe<String> f1, f2, f3, f4;
    
    @Before
    public void setup() {
        plan = new PipePlan(); 
        p1 = new Phase();
        p2 = new Phase();
        p3 = new Phase();
        f1 = Pipe.of("");
        f2 = Pipe.of("");
        f3 = Pipe.of("");
        f4 = Pipe.of("");
        f1.at("f1");
        f2.at("f2");
        f3.at("f3");
        f4.at("f4");
    }
    
    @Test
    public void pairDependencyFails() {
        try {
            plan.fileCreateWith(f1, p1);
            plan.processReads(p1, f2);
            plan.fileCreateWith(f2, p2);
            plan.processReads(p2, f1);
            plan.plan();
            fail("Should throw exception for cyclic dependency");
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().contains("Cyclic dependency among files:"));
        }
    }
    
    @Test
    public void cyclicDependencyFails() {
        try {
            plan.fileCreateWith(f1, p1);
            plan.processReads(p1, f2);
            plan.fileCreateWith(f2, p2);
            plan.processReads(p2, f3);
            plan.fileCreateWith(f3, p3);
            plan.processReads(p3, f1);
            plan.plan();
            fail("Should throw exception for cyclic dependency");
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().contains("Cyclic dependency among files:"));
        }        
    }
    
    @Test
    public void planningLifecycle() {
        fileCreateWith(f1, p1);
        plan.processReads(p1, f2);
        fileCreateWith(f2, p2);
        plan.processReads(p2, f3);
        plan.processReads(p1, f4);
        plan.plan();
        List<Phase> np = plan.getNextProcesses();
        assertTrue(np.contains(p2));
        assertEquals(1, np.size());
        
        plan.updated(p2);
        plan.plan();
        np = plan.getNextProcesses();
        assertEquals(1, np.size());
        assertTrue(np.contains(p1));
    }
    
    @Test
    public void duplicateFiles() {
        Pipe<String> f1p = Pipe.of("").at(f1.getPath()); 
        fileCreateWith(f1, p1);
        fileCreateWith(f1p, p2);
        
        plan.processReads(p1, f2);
        plan.processReads(p2, f3);
        plan.plan();
        List<Phase> np = plan.getNextProcesses();
        assertTrue(np.contains(p1) || np.contains(p2));
        assertEquals(1, np.size());        
    }

    private void fileCreateWith(Pipe f, Phase p) {
        plan.fileCreateWith(f, p);
        f.setProducer(p);
        p.writes(f);
    }
}
