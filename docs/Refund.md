# Refund

Method | HTTP request | Description
------------- | ------------- | -------------
[**initiateRefund**](Refund.md#initiateRefund) | **POST** /refund/api/v1/async/refund | Initiates the Refund


<a name="initiateRefund"></a>
# **initiateRefund**
>SDKResponse<AsyncRefundResponse> initiateRefund(refundDetail)

Initiate the Refund process for any previous successful transaction

### Example
```java
// imports
// import com.paytm.merchant.models.Time;
// import com.paytm.merchant.models.RefundDetail;
// import com.paytm.pg.Refund;
// import com.paytm.merchant.models.SDKResponse;
// import com.paytm.pgplus.response.AsyncRefundResponse;
// import java.util.concurrent.TimeUnit;

/** Unique order for each order request */
String orderId = "orderId";
/** REF ID returned in Payment call */
String refId = "refId";
/** Transaction ID returned in Payment Api */
String txnId = "transactionId";
/** Transaction Type returned in Payment Api */
String txnType = "REFUND";
/**
 * Refund Amount to be refunded (should not be greater than the Amount paid in
 * the Transaction)
 */
String refundAmount = "1";
Time readTimeout = new Time(5, TimeUnit.MINUTES);

/**
 * refund object will have all the information required to make refund call
 */
RefundDetail refund = new RefundDetail.RefundDetailBuilder(orderId, refId, txnId, txnType, refundAmount)
		.setReadTimeout(readTimeout).build();

/**
 * Making call to SDK method which will return a SDKResponse(AsyncRefundResponse) object
 * that will contain the Refund Response regarding the Transaction Id
 */
SDKResponse<AsyncRefundResponse> response = Refund.doRefund(refund);
System.out.println(response);

/** ..... Merchants code here .... */
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **refund** | [**RefundDetail**](RefundDetail.md)| Holds data regarding the refund |

### Return type

[**SDKResponse**](SDKResponse.md)  having  [**AsyncRefundResponse**](AsyncRefundResponse.md)  object.

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


<a name="getRefundStatus"></a>
# **getRefundStatus**
>SDKResponse<NativeRefundStatusResponse> getRefundStatus(refundStatusDetail)

Returns the Refund status

### Example
```java
// imports
// import com.paytm.merchant.models.Time;
// import com.paytm.merchant.models.RefundStatusDetail;
// import com.paytm.pg.Refund;
// import com.paytm.merchant.models.SDKResponse;
// import com.paytm.pgplus.response.NativeRefundStatusResponse;
// import java.util.concurrent.TimeUnit;

/** ..... Merchants code here .... */
/** 4. Merchants who want to get Refund Status */

/** Unique order for each order request */
String orderId = "PARCEL442794";
/** Unique ref id for each refund request */
String refId = "ref78904530056130";
Time readTimeout = new Time(5, TimeUnit.MINUTES);

/**
 * RefundStatusDetail object will have all the information required to make
 * getRefundStatus call
 */
RefundStatusDetail refundStatusDetail = new RefundStatusDetail.RefundStatusDetailBuilder(orderId, refId)
		.setReadTimeout(readTimeout).build();
		
/**
 * Making call to SDK method which will return the
 * SDKResponse(NativeRefundStatusRequest) that holds Refund Status of any
 * previous Refund.
 */
SDKResponse<NativeRefundStatusResponse> response = Refund.getRefundStatus(refundStatusDetail);
System.out.println(response);

/** ..... Merchants code here .... */
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **refundStatusDetail** | [**RefundStatusDetail**](RefundStatusDetail.md)| Holds data regarding the refund status |

### Return type

[**SDKResponse**](SDKResponse.md)  having  [**NativeRefundStatusResponse**](NativeRefundStatusResponse.md)  object.

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


