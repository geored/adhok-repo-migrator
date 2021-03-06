/**
 * Copyright (C) 2018 Red Hat, Inc. (jdcasey@commonjava.org)
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
package org.indy.geored.repomigrator.boot;

import org.commonjava.atservice.annotation.Service;
import org.commonjava.propulsor.boot.BootInterface;
import org.commonjava.propulsor.boot.BootOptions;
import org.commonjava.propulsor.boot.Booter;


@Service(BootInterface.class)
public class Main
{
    public static void main( String[] args ) throws Exception
    {
        BootOptions ops = Booter.loadFromSysProps(
          "repomigrator",
          "repomigrator.boot.defaults",
          "repomigrator.home");

        new Booter()
          .runAndWait(ops);
    }
}
