package org.aziz.quince.service.features;

import org.aziz.quince.model.Feature;

import java.util.List;
import java.util.Map;

public interface FeatureService {

    Map<String, List<Feature>> retrieveFeatures();
    boolean isActive(String featureTitle);
    int countFeatures();
}
