package org.aziz.quince.service.features;

public class FeatureServiceImplBuilder {
    private String url_jsonFile;
    private String pod_group_value;

    public FeatureServiceImplBuilder setUrl_jsonFile(String url_jsonFile) {
        this.url_jsonFile = url_jsonFile;
        return this;
    }

    public FeatureServiceImplBuilder setPOD_GROUP_VALUE(String pod_group_value) {
        this.pod_group_value = pod_group_value;
        return this;
    }

    public FeatureServiceImpl createFeatureServiceImpl() {
        return new FeatureServiceImpl(url_jsonFile, pod_group_value);
    }
}