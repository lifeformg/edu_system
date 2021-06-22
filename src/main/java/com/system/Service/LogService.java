package com.system.Service;

import com.system.entity.Userlogin;
import org.springframework.stereotype.Service;

public interface LogService {
    public boolean login(String username , String password);
}
