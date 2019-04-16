# Paytm Java SDK

Official java bindings for the Paytm API.  [Api Link]

## Documentation

Documentation of Paytm's API and their usage is available at [Paytm Docs](https://developer.paytm.com/docs/)

## Requirements

Java 1.7 or later

## Installation

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.paytm.pg</groupId>
    <artifactId>pg-java</artifactId>
    <version>0.0.1</version>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.paytm.pg:pg-java:0.0.1"
```

## Usage

Merchant will integrate Paytm Payment Gateway from below 2 steps:


### 1. Initialization of initial parameters

Merchant will initialize initial parameters (environment, mid, key, clientId, website) by calling MerchantProperties.initialize() method.

Environment should be "STAGE" for Staging/Testing and "PROD" for Production.
You can obtain mid, key, clientId, website from Dashboard [Link/Documents]

```java
// imports
// import com.paytm.pg.constants.MerchantProperties;

/** Setting Initial Parameters */
MerchantProperties.initialize("environment", "mid", "key", "clientId", "website");
```

Setting Callback URL

Callback URL will set by using MerchantProperties.setCallbackUrl() method. This url will be used in initiateTransaction API call.

```java
// imports
// import com.paytm.pg.constants.MerchantProperties;

/** Setting Callback URL */
MerchantProperties.setCallbackUrl(callbackUrl);
```


Add custom Connection Timeout for request (optional)

```java
// imports
// import com.paytm.pg.constants.MerchantProperties;
// import com.paytm.merchant.models.Time;
// import java.util.concurrent.TimeUnit;

/** Setting timeout for connection i.e. Connection Timeout */
MerchantProperties.setConnectionTimeout(new Time(5, TimeUnit.MINUTES));
```

Set java logger level and log file path for sdk logs (optional)

```java
// imports
// import com.paytm.pg.constants.LibraryConstants;
// import java.util.logging.FileHandler;
// import java.util.logging.Level;
// import java.util.logging.SimpleFormatter;

/** Set Logger Level for Paytm logs */
LibraryConstants.LOGGER.setLevel(Level.ALL);

/** setting log file path "/paytm/MyLogFile.log" */
try {
	FileHandler fh = null;
	fh = new FileHandler("/paytm/MyLogFile.log");
	fh.setFormatter(new SimpleFormatter());
	LibraryConstants.LOGGER.addHandler(fh);

	/** Removing console handler from logger */
	LibraryConstants.LOGGER.setUseParentHandlers(false);
} catch (IOException e) {
	LibraryConstants.LOGGER.log(Level.SEVERE, e.toString(), e);
}
```


### 2. Integrate SDK Payment Gateway API

After initializing the initial parameters, Merchant can call SDK methods to call Payment Gateway API's.

## SDK Apis

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*Payment* | [**createTxnToken**](docs/Payment.md#createTxnToken) | **POST** /theia/api/v1/initiateTransaction | Create Transaction Token
*Payment* | [**getPaymentStatus**](docs/Payment.md#getPaymentStatus) | **POST** /merchant-status/api/v1/getPaymentStatus | Get Payment Status
*Refund* | [**initiateRefund**](docs/Refund.md#initiateRefund) | **POST** /refund/api/v1/async/refund | Initiate Refund
*Refund* | [**getRefundStatus**](docs/Refund.md#getRefundStatus) | **POST** /refund/api/v1/refundStatus | Get Refund Status


## Documentation for Models

 - [AsyncRefundResponse](docs/AsyncRefundResponse.md)
 - [AsyncRefundResponseBody](docs/AsyncRefundResponseBody.md)
 - [BaseResponseBody](docs/BaseResponseBody.md)
 - [ChildTransaction](docs/ChildTransaction.md)
 - [ExtraParameterMap](docs/ExtraParameterMap.md)
 - [InitiateTransactionResponse](docs/InitiateTransactionResponse.md)
 - [InitiateTransactionResponseBody](docs/InitiateTransactionResponseBody.md)
 - [NativePaymentStatusResponse](docs/NativePaymentStatusResponse.md)
 - [NativePaymentStatusResponseBody](docs/NativePaymentStatusResponseBody.md)
 - [NativeRefundStatusResponse](docs/NativeRefundStatusResponse.md)
 - [NativeRefundStatusResponseBody](docs/NativeRefundStatusResponseBody.md)
 - [PaymentDetail](docs/PaymentDetail.md)
 - [PaymentStatusDetail](docs/PaymentStatusDetail.md)
 - [RefundDetail](docs/RefundDetail.md)
 - [RefundStatusDetail](docs/RefundStatusDetail.md)
 - [ResponseHeader](docs/ResponseHeader.md)
 - [ResultInfo](docs/ResultInfo.md)
 - [SDKResponse](docs/SDKResponse.md)
 - [SecureResponseHeader](docs/SecureResponseHeader.md)
 - [Time](docs/Time.md)
