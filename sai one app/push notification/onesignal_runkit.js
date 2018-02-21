var OneSignal = require("onesignal-node");
var myClient = new OneSignal.Client({
    app: { appAuthKey: 'OTc3ZDgwMmQtZGJhNy00NDJiLTkwOTMtZmEzZmY3NjlmMzhh', appId: '22dc5e35-2b13-4749-a187-8e7e1d64718f' }
});

myClient.viewDevice('84e44467-ca4e-4022-b4a0-107490478404', function (err, httpResponse, data) {
    console.log(data);
});

myClient.viewNotifications('limit=30', function (err, httpResponse, data) {
    if (httpResponse.statusCode === 200 && !err) {
        console.log(data);
    }
});