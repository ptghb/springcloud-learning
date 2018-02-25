package com.pt.eurekafeign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.pt.eurekaapi.ComputeService;

@FeignClient(name="compute-service",fallback=ComputeFallback.class)
public interface ComputeClient extends ComputeService {
}