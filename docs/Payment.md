# Payment

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTxnToken**](Payment.md#createTxnToken) | **POST** /theia/api/v1/initiateTransaction | Returns a token which will be used in further frontend Payment calls
[**getPaymentStatus**](Payment.md#getPaymentStatus) | **POST** /merchant-status/api/v1/getPaymentStatus | Returns the Payment status 


<a name="createTxnToken"></a>
# **createTxnToken**
>SDKResponse<InitiateTransactionResponse> createTxnToken(paymentDetails)

Returns a token which will be used in further frontend Payment calls.

### Example
```java
// imports
// import com.paytm.pgplus.enums.EChannelId;
// import com.paytm.pgplus.models.Money;
// import com.paytm.pgplus.models.UserInfo;
// import com.paytm.merchant.models.Time;
// import com.paytm.merchant.models.PaymentDetail;
// import com.paytm.pg.Payment;
// import com.paytm.merchant.models.SDKResponse;
// import com.paytm.pgplus.response.InitiateTransactionResponse;
// import java.util.concurrent.TimeUnit;

/** Channel through which call initiated */
EChannelId channelId = EChannelId.WEB;
/** Unique order for each order request */
String orderId = "orderId";
/** Transaction amount and the currency value */
Money txnAmount = new Money(EnumCurrency.INR, "1.00");
/**
 * User information contains user details cid : <Mandatory> user unique
 * identification with respect to merchant
 */
UserInfo userInfo = new UserInfo();
userInfo.setCustId("customerid");
/**
 * paymentDetails object will have all the information required to make
 * createTxnToken call
 */
PaymentDetail paymentDetails = new PaymentDetail.PaymentDetailBuilder(channelId, orderId, txnAmount, userInfo)
		.build();
/**
 * Making call to SDK method which will return the
 * SDKResponse(InitiateTransactionResponse) that holds the createTxnToken result
 * parameter which will be used by merchant in future API calls.
 */
SDKResponse<InitiateTransactionResponse> response = Payment.createTxnToken(paymentDetails);
System.out.println(response.getResponseObject().getBody().getTxnToken());
/** ..... Merchants code here .... */
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **paymentDetails** | [**PaymentDetail**](PaymentDetail.md)| Returns the Payment status |

### Return type

[**SDKResponse**](SDKResponse.md)  having  [**InitiateTransactionResponse**](InitiateTransactionResponse.md)  object.

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


<a name="getPaymentStatus"></a>
# **getPaymentStatus**
>SDKResponse<NativePaymentStatusResponse> getPaymentStatus(paymentStatusDetail)

Returns the Payment status

### Example
```java
// imports
// import com.paytm.merchant.models.Time;
// import com.paytm.merchant.models.PaymentStatusDetail;
// import com.paytm.pg.Payment;
// import com.paytm.merchant.models.SDKResponse;
// import com.paytm.pgplus.response.NativePaymentStatusResponse;
// import java.util.concurrent.TimeUnit;

/** ..... Merchants code here .... */
/** 4. Merchants who want to get TransactionStatus */

/** Unique order for each order request */
String orderId = "orderId";
Time readTimeout = new Time(5, TimeUnit.MINUTES);

/**
 * PaymentStatusDetail object will have all the information required to make
 * getPaymentStatus call
 */
PaymentStatusDetail paymentStatusDetail = new PaymentStatusDetail.PaymentStatusDetailBuilder(orderId)
		.setReadTimeout(readTimeout).build();

/**
 * Making call to SDK method which will return the
 * SDKResponse(NativePaymentStatusResponse) that holds Payment Status of any
 * previous transaction.
 */
SDKResponse<NativePaymentStatusResponse> response = Payment.getPaymentStatus(paymentStatusDetail);
System.out.println(response);

/** ..... Merchants code here .... */
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **paymentStatusDetail** | [**PaymentStatusDetail**](PaymentStatusDetail.md)| Holds data regarding the payment status |

### Return type

[**SDKResponse**](SDKResponse.md)  having  [**NativePaymentStatusResponse**](NativePaymentStatusResponse.md)  object.

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


