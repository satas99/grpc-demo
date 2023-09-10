package com.grpc.client.service;

import com.google.protobuf.Descriptors;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface BookAuthorService {
    Map<Descriptors.FieldDescriptor, Object> getAuthor(int authorId);
    CompletableFuture<List<Map<Descriptors.FieldDescriptor, Object>>> getBooksByAuthor(int authorId) throws InterruptedException;
}
