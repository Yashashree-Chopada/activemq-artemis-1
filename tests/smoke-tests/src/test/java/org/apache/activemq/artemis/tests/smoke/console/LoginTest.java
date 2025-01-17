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

import org.apache.activemq.artemis.tests.smoke.console.pages.LoginPage;
import org.junit.Test;
import org.openqa.selenium.MutableCapabilities;

public class LoginTest extends ConsoleTest {

   private static final String DEFAULT_CONSOLE_LOGIN_BRAND_IMAGE = "/activemq-branding/plugin/img/activemq.png";

   public LoginTest(MutableCapabilities browserOptions) {
      super(browserOptions);
   }

   @Test
   public void testLogin() {
      driver.get(webServerUrl + "/console");
      LoginPage loginPage = new LoginPage(driver);
      loginPage.loginValidUser(SERVER_ADMIN_USERNAME, SERVER_ADMIN_PASSWORD, DEFAULT_TIMEOUT);
   }

   @Test
   public void testLoginBrand() {
      String expectedBrandImage = webServerUrl + System.getProperty(
         "artemis.console.login.brand.image", DEFAULT_CONSOLE_LOGIN_BRAND_IMAGE);

      driver.get(webServerUrl + "/console");
      LoginPage loginPage = new LoginPage(driver);
      assertEquals(expectedBrandImage, loginPage.getBrandImage(DEFAULT_TIMEOUT));
   }
}
