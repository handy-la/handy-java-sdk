package com.handy.demo;

import com.handy.sdk.HandySDK;
import com.handy.sdk.beans.SalesOrder;
import com.handy.sdk.exceptions.HandySDKException;
import com.handy.sdk.job.beans.JobHandler;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws HandySDKException {
        System.out.println("Initializing...");
        HandySDK.init(new JobHandler() {
            @Override
            public void process(Set<SalesOrder> set) {
                // TODO Implement your logic here
                for (SalesOrder salesOrder : set) {
                    //System.out.println("Sales Order: " + salesOrder);
                }
            }
        });
    }
}