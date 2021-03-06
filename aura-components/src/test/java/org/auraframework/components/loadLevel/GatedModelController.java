/*
 * Copyright (C) 2013 salesforce.com, inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.auraframework.components.loadLevel;

import org.auraframework.annotations.Annotations.ServiceComponent;
import org.auraframework.ds.servicecomponent.Controller;
import org.auraframework.system.Annotations.AuraEnabled;
import org.auraframework.system.Annotations.Key;

@ServiceComponent
public class GatedModelController implements Controller {

    @AuraEnabled
    public void resumeGateId(@Key("waitId") String waitId) {
        if (waitId == null) {
            return;
        }
        GateKeeper.releaseGate(waitId);
    }

    @AuraEnabled
    public void clearGateId(@Key("waitId") String waitId) {
        if (waitId == null) {
            return;
        }
        GateKeeper.clearGate(waitId);
    }
}
