package br.com.leo.restwithspringboot.mappers

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import org.springframework.http.MediaType
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter

class YamlJacksonMapper: AbstractJackson2HttpMessageConverter(YAMLMapper(), MediaType.parseMediaType("application/x-yaml"))