package com.orderfood.service;

import com.orderfood.pojo.OrderfoodIndent;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IndentService {
    List<OrderfoodIndent> getAll();
}
