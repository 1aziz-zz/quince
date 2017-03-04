package org.aziz.quince.service.features;

import org.aziz.quince.model.Feature;

import java.util.List;
import java.util.Map;

/**
 * Created by aziz on 3-3-17 :)
 */
class FeaturesCalculator {
    int compute(Map<String, List<Feature>> features) {
        return features.size();
    }
}
