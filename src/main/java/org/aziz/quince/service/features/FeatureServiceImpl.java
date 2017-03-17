package org.aziz.quince.service.features;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aziz.quince.model.Feature;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeatureServiceImpl implements FeatureService {
    private String url_jsonFile;
    private String POD_GROUP_VALUE;
    private Map<String, List<Feature>> features = new HashMap<>();

    FeatureServiceImpl(String url_jsonFile, String POD_GROUP_VALUE) {
        this.url_jsonFile = url_jsonFile;
        this.POD_GROUP_VALUE = POD_GROUP_VALUE;
        features = this.getJsonObjects();
    }
    // Refactoring: Replace Constructor with Factory Method
    // Refactoring: Replace Constructor with Builder
    public static FeatureServiceImpl create(String url_jsonFile, String POD_GROUP_VALUE) {
        return new FeatureServiceImplBuilder().
                setUrl_jsonFile(url_jsonFile).
                setPOD_GROUP_VALUE(POD_GROUP_VALUE).
                createFeatureServiceImpl();
    }


    // Refactoring:  Extract method:
    @Override
    public Map<String, List<Feature>> retrieveFeatures() {
        return features;
    }

    private Map<String, List<Feature>> getJsonObjects() {
        Map<String, List<Feature>> results = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            results = objectMapper.readValue(new URL(url_jsonFile),
                    new TypeReference<Map<String, List<Feature>>>() {
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public boolean isActive(String featureTitle) {
        if (this.groupExists()) {
            for (Feature feature : this.retrieveFeatures().get(POD_GROUP_VALUE)) {
                if (feature.getTitle().equals(featureTitle) && feature.getStatus()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean groupExists() {
        return features.keySet().contains(POD_GROUP_VALUE);
    }

    //Refactoring:  Replace Method with Method Object
    @Override
    public int countFeatures() {
        FeaturesCalculator featuresCalculator = new FeaturesCalculator();
        return featuresCalculator.compute(this.retrieveFeatures());
    }
}
