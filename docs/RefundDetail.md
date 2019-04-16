# PaymentStatusDetail

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**orderId** | **String** | Unique order for each order request  |  [required]
**refId** | **String** | REF ID returned in Payment call  |  [required]
**txnId** | **String** | Transaction ID returned in Payment Api  |  [required]
**txnType** | **String** | Transaction Type returned in Payment Api  |  [required]
**refundAmount** | **String** | Refund Amount to be refunded  |  [required]
**workFlow** | **String** |   |  [optional]
**comments** | **String** | comments merchant want to add in refund |  [optional]
**preferredDestination** | **String** |   |  [optional]
**requestId** | **String** |   |  [optional]
**subwalletAmount** | **Map<UserSubWalletType, BigDecimal>** |   |  [optional]
**extraParamsMap** | **Map<String, Object>** |   |  [optional]
**readTimeout** | **Time** | Read TimeOut for Payment Api |  [optional]



