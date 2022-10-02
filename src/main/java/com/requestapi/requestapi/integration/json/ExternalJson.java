package com.requestapi.requestapi.integration.json;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Map;

public abstract class ExternalJson extends ExternalJsonLowLevel {
    public static <T, A> List<A> createRequestClassListFromJsonString(T response, Class<A> clazz) {
        JsonNode jsonNode = parse((String) response);
        List<JsonNode> jsonNodes = jsonNodesFromJsonNode(jsonNode);
        List<A> customClassList = genericListFromJsonNodes(jsonNodes,clazz);
        return customClassList;
    }
    public static <T, A> A createRequestClassObjectFromJsonString(T response, Class<A> clazz) {
        JsonNode jsonNode = parse((String) response);
        A customClassList = fromJson(jsonNode,clazz);
            return customClassList;
    }
}
