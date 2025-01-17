/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.activemq.artemis.tests.smoke.console;

import org.apache.activemq.artemis.tests.smoke.console.pages.IndexPage;
import org.junit.Test;
import org.openqa.selenium.MutableCapabilities;

public class IndexTest extends ConsoleTest {

   protected static final String DEFAULT_CONSOLE_INDEX_LOGO_IMAGE = "/images/activemq-logo.png";

   public IndexTest(MutableCapabilities browserOptions) {
      super(browserOptions);
   }

   @Test
   public void testIndexLogo() {
      String expectedLogoImage = webServerUrl + System.getProperty(
         "artemis.console.index.logo.image", DEFAULT_CONSOLE_INDEX_LOGO_IMAGE);

      driver.get(webServerUrl);
      IndexPage indexPage = new IndexPage(driver);
      assertEquals(expectedLogoImage, indexPage.getLogoImage(DEFAULT_TIMEOUT));
   }
}
