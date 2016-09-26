/*
 * Copyright 1999-2101 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.bvt.sql.mysql.alter;

import org.junit.Assert;
import junit.framework.TestCase;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.parser.Token;

public class MySqlAlterTableTest2 extends TestCase {

    public void test_alter_first() throws Exception {
        String sql = "ALTER TABLE `test`.`tb1` ADD COLUMN `f2` VARCHAR(45) NULL  FIRST ;";
        MySqlStatementParser parser = new MySqlStatementParser(sql);
        SQLStatement stmt = parser.parseStatementList().get(0);
        parser.match(Token.EOF);
        String output = SQLUtils.toMySqlString(stmt);
        Assert.assertEquals("ALTER TABLE `test`.`tb1`\n\tADD COLUMN `f2` VARCHAR(45) NULL FIRST", output);
    }

    public void test_alter_add_column() throws Exception {
        String sql = "ALTER TABLE `test`.`tb1` ADD COLUMN `f2` VARCHAR(45) NULL  AFTER `fid` , ADD COLUMN `f3` VARCHAR(45) NULL  FIRST `f2`";
        MySqlStatementParser parser = new MySqlStatementParser(sql);
        SQLStatement stmt = parser.parseStatementList().get(0);
        parser.match(Token.EOF);
        String output = SQLUtils.toMySqlString(stmt);
        Assert.assertEquals("ALTER TABLE `test`.`tb1`" + //
                            "\n\tADD COLUMN `f2` VARCHAR(45) NULL AFTER `fid`," + //
                            "\n\tADD COLUMN `f3` VARCHAR(45) NULL FIRST `f2`", output);
    }

}
