/*
 * Copyright 2016 Cognifide Ltd..
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
package com.cognifide.qa.bb.aem.touch.siteadmin.aem61;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.Global;
import com.cognifide.qa.bb.qualifier.PageObject;

@PageObject
public class TemplateList {

  @Global
  @FindBy(css = "article.foundation-collection-item")
  private List<WebElement> templates;

  void selectTemplate(String templateName) {
    WebElement template = templates.stream()
        .filter(t -> StringUtils.
            equals(t.findElement(By.cssSelector("div.label > h4")).getText(), templateName))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Template not found: " + templateName));

    template.click();
  }

}
