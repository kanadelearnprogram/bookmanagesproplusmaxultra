package com.book.Service;

import jakarta.servlet.http.HttpSession;

public interface UserService {
   public boolean auth(String username, String password, HttpSession session) ;
}
