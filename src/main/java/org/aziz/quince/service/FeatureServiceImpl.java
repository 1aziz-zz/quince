package org.aziz.quince.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aziz.quince.model.Feature;

import java.net.URL;
import java.util.List;
import java.util.Map;

public class FeatureServiceImpl implements FeatureService {
    private String url_jsonFile;
    private String POD_GROUP_VALUE;

    public FeatureServiceImpl(String url_jsonFile, String POD_GROUP_VALUE) {
        this.url_jsonFile = url_jsonFile;
        this.POD_GROUP_VALUE = POD_GROUP_VALUE;
    }

    @Override
    public Map<String, List<Feature>> retrieveFeatures() {
        return getStringListMap();
    }

    private Map<String, List<Feature>> getJsonObjects() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new URL(url_jsonFile),
                    new TypeReference<Map<String, List<Feature>>>() {
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Map<String, List<Feature>> getStringListMap() {
        Map<String, List<Feature>> features;
        features = this.getJsonObjects();
        return features;
    }
    @Override
    public boolean isActive(String featureTitle) {
        if (this.groupExists()) {
            for (Feature feature : this.retrieveFeatures().get(POD_GROUP_VALUE)) {
                if (feature.getTitle().equals(featureTitle)) {
                    if (feature.getStatus()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean groupExists() {
        return this.retrieveFeatures().keySet().contains(POD_GROUP_VALUE);
    }

}
