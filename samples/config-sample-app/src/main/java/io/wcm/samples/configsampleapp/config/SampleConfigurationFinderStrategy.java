/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2014 wcm.io
 * %%
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
 * #L%
 */
package io.wcm.samples.configsampleapp.config;

import io.wcm.config.spi.ConfigurationFinderStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.Resource;

import com.day.jcr.vault.util.Text;

/**
 * Sample configuration finder strategy wich accepts absolute root levels 1/2/3 as site configuration id.
 */
@Component(immediate = true)
@Service
public class SampleConfigurationFinderStrategy implements ConfigurationFinderStrategy {

  @Override
  public String getApplicationId() {
    return Params.APPLICATION_ID;
  }

  @Override
  public Iterator<String> findConfigurationIds(Resource resource) {
    List<String> configurationIds = new ArrayList<>();
    addAbsoluteParent(configurationIds, resource, 3);
    addAbsoluteParent(configurationIds, resource, 2);
    addAbsoluteParent(configurationIds, resource, 1);
    return configurationIds.iterator();
  }

  private void addAbsoluteParent(List<String> configurationIds, Resource resource, int absoluteParent) {
    String configurationId = Text.getAbsoluteParent(resource.getPath(), absoluteParent);
    if (StringUtils.isNotEmpty(configurationId)) {
      configurationIds.add(configurationId);
    }
  }

}