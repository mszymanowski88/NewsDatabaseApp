package com.example.newsdatabaseapp.api;


import com.mashape.unirest.http.exceptions.UnirestException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Response {

  String userInput;
  String status;
  String userTier;
  int total;
  int startIndex;
  int pageSize;
  int currentPage;
  int pages;
  String orderBy;
  Article[] results;

  public Response() {



  }

  public Response(final String status, final String userTier, final int total, final int startIndex, final int pageSize, final int currentPage, final int pages, final String orderBy, final Article[] results, String userInput) {
    this.status = status;
    this.userTier = userTier;
    this.total = total;
    this.startIndex = startIndex;
    this.pageSize = pageSize;
    this.currentPage = currentPage;
    this.pages = pages;
    this.orderBy = orderBy;
    this.results = results;
    this.userInput = userInput;
  }

  public String getStatus() {
    return status;
  }

  public String getUserInput() {
    return userInput;
  }

  public void setUserInput(String userInput) {
    this.userInput = userInput;
  }

  public void setStatus(final String status) {
    this.status = status;
  }

  public String getUserTier() {
    return userTier;
  }

  public void setUserTier(final String userTier) {
    this.userTier = userTier;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(final int total) {
    this.total = total;
  }

  public int getStartIndex() {
    return startIndex;
  }

  public void setStartIndex(final int startIndex) {
    this.startIndex = startIndex;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(final int pageSize) {
    this.pageSize = pageSize;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(final int currentPage) {
    this.currentPage = currentPage;
  }

  public int getPages() {
    return pages;
  }

  public void setPages(final int pages) {
    this.pages = pages;
  }

  public String getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(final String orderBy) {
    this.orderBy = orderBy;
  }

  public Article[] getResults() {
    return results;
  }

  public void setResults(final Article[] results) {
    this.results = results;
  }

  public List<Article> userQueryGuardian (String userInput) throws UnirestException, ParseException {

    userInput = this.userInput;
    System.out.println("User input response "+userInput);
//      userInput = "Poland";
    GuardianContentApi api = new GuardianContentApi("cdebde7d-5c15-4657-9f39-5e7bcb513794");
    SimpleDateFormat s = new SimpleDateFormat();
    System.out.println(Arrays.stream(api.getContent(userInput).getResults()).collect(Collectors.toList()));

    return Arrays.stream(api.getContent(userInput).getResults()).collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return "Response{" +
            "status='" + status + '\'' +
            ", userTier='" + userTier + '\'' +
            ", total=" + total +
            ", startIndex=" + startIndex +
            ", pageSize=" + pageSize +
            ", currentPage=" + currentPage +
            ", pages=" + pages +
            ", orderBy='" + orderBy + '\'' +
            ", results=" + Arrays.toString(results) +
            '}';
  }
}