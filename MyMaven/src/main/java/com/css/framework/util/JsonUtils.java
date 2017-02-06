package com.css.framework.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang.StringUtils;

public class JsonUtils
{
  public static String toJsonString(Object obj)
  {
    return toJsonString(obj, true);
  }

  public static String toJsonString(Object obj, boolean seralizerClass)
  {
    if (obj != null) {
      if (((obj instanceof String)) && (StringUtils.isBlank((String)obj)))
        return "";
      try
      {
        if (seralizerClass) {
          return JSON.toJSONString(obj, new SerializerFeature[] { SerializerFeature.WriteClassName });
        }
        return JSON.toJSONString(obj);
      }
      catch (Exception e) {
        return "null";
      }
    }
    return "null";
  }

  public static Object jsonParseObject(String json)
  {
    if (StringUtils.isBlank(json))
      return "";
    if (StringUtils.equalsIgnoreCase(json, "null")) {
      return null;
    }
    return JSON.parse(json);
  }

  public static <T> T toObject(String json, Class<T> clazz)
  {
    if (StringUtils.isBlank(json))
      return null;
    if (json.equalsIgnoreCase("null")) {
      return null;
    }

    return JSON.parseObject(json, clazz);
  }
}