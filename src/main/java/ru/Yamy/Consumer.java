package ru.Yamy;

import org.springframework.web.client.RestTemplate;

public class Consumer {
    private RestTemplate restTemplate;

    private String getPostPutUrl =  "http://94.198.50.185:7081/api/users";

    private String getResponse = "";

    private String postResponse = "";

    private  String putResponse = "";

    private String deleteResponse = "";

    public Consumer(RestTemplate restTemplate, String getPostPutUrl, String deleteUrl) {
        this.restTemplate = restTemplate;
        this.getPostPutUrl = getPostPutUrl;
    }


    public String getGetResponse() {
        return getResponse;
    }

    public void setGetResponse(String getResponse) {
        this.getResponse = getResponse;
    }

    public String getPostResponse() {
        return postResponse;
    }

    public void setPostResponse(String postResponse) {
        this.postResponse = postResponse;
    }

    public String getPutResponse() {
        return putResponse;
    }

    public void setPutResponse(String putResponse) {
        this.putResponse = putResponse;
    }

    public String getDeleteResponse() {
        return deleteResponse;
    }

    public void setDeleteResponse(String deleteResponse) {
        this.deleteResponse = deleteResponse;
    }

    public Consumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Consumer() {
    }


    public String getGetPostPutUrl() {
        return getPostPutUrl;
    }

    public void setGetPostPutUrl(String getPostPutUrl) {
        this.getPostPutUrl = getPostPutUrl;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
