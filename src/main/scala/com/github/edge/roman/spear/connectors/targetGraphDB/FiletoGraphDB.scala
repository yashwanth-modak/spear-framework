/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.github.edge.roman.spear.connectors.targetGraphDB

import com.github.edge.roman.spear.Connector
import com.github.edge.roman.spear.commons.{ConnectorCommon, SpearCommons}
import com.github.edge.roman.spear.connectors.AbstractTargetGraphDBConnector

class FiletoGraphDB(sourceFormat: String, destFormat: String) extends AbstractTargetGraphDBConnector(sourceFormat, destFormat) {

  override def source(sourceFilePath: String, params: Map[String, String]): FiletoGraphDB = {
    logger.info(s"Connector:${appName} to Target:GraphDB with Format:${destFormat} from Source:${sourceFilePath} with Format:${sourceFilePath} started running !!")
    this.df = ConnectorCommon.sourceFile(sourceFormat, sourceFilePath, params)
    logger.info(s"Reading source file: ${sourceFilePath} with format: ${sourceFormat} status:${SpearCommons.SuccessStatus}")
    show()
    this
  }

  override def sourceSql(params: Map[String, String], sqlText: String): Connector = throw new NoSuchMethodException(s"method sourceSql is not supported for given sourceType file for connector type FiletoGraphDB")

}