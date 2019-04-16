# PaymentDetail

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**channelId** | **EChannelId** | Channel through which call initiated  |  [required]
**orderId** | **String** | Unique order for each order request  |  [required]
**txnAmount** | **Money** | Transaction amount and the currency value  |  [required]
**userInfo** | **UserInfo** | User information contains user details  |  [required]
**paytmSsoToken** | **String** | Paytm Token for a user  |  [optional]
**enablePaymentMode** | **List<PaymentMode>** | list of the payment modes which needs to enable  |  [optional]
**disablePaymentMode** | **List<PaymentMode>** | list of the payment modes which needs to disable  |  [optional]
**goods** | **List<GoodsInfo>** | This contain the Goods info for an order.  |  [optional]
**shippingInfo** | **List<ShippingInfo>** | This contain the shipping info for an order.  |  [optional]
**workFlow** | **String** |   |  [optional]
**promoCode** | **String** | Promocode that user is using for the payment  |  [optional]
**extendInfo** | **ExtendInfo** | This contain the set of parameters for some additional information  |  [optional]
**emiOption** | **String** |   |  [optional]
**cardTokenRequired** | **String** |   |  [optional]
**cartValidationRequired** | **String** |   |  [optional]
**readTimeout** | **Time** | Read TimeOut for Payment Api |  [optional]



