var stompClient = null;
var notificationCount = 0;
var globalNotificationCount = 0;
var privateNotificationCount = 0;

$().ready( () => {
    console.log('welcome to use websocket.');
    connect();

    $('#send').click( () => {
        console.log('click the button of send.');
        sendMessage();
    });

    $('#send-private').click( () => {
        console.log('click the button of send-private.');
        sendPrivateMessage();
    });

    $('#notifications').click( () => {
        console.log('click the button of notifications.');
        resetNotificationCount();
    });
});


var connect = () => {
    console.log('呼叫 connect');

    var socket = new SockJS('/websocket');
    stompClient = Stomp.over(socket);

    // stomp client connection.
    stompClient.connect({}, (frame) => {
        console.log('Connected: ' + frame);

        // update notification count.
        updateNotificationAndDisplay();

        // subscribe message, private message, notification, private notification.
        stompClient.subscribe('/topic/messages', (message) => {
            console.log('呼叫 /topic/messages.');
            showMessage(JSON.parse(message.body).content);
        });

        stompClient.subscribe('/user/topic/private-messages', (message) => {
            console.log('呼叫 /user/topic/private-messages.');
            showMessage(JSON.parse(message.body).content);
        });

        stompClient.subscribe('/topic/global-notifications', (message) => {
            console.log('呼叫 /topic/global-notifications.');
            notificationCount = notificationCount + 1;
            updateNotificationAndDisplay();
        });

        stompClient.subscribe('/user/topic/private-notifications', (message) => {
            console.warn('message: ', message);
            console.log('呼叫 /user/topic/private-notifications.');

            notificationCount = notificationCount + 1;
            updateNotificationAndDisplay();
        });
    })
}

var showMessage = (message) => {
    console.log("呼叫 showMessage");

    $("#messages").append("<tr><td>" + message + "</td></tr>");
}

var sendMessage = () => {
    console.log("呼叫 sendMessage");

    stompClient.send("/ws/message", {}, JSON.stringify({'messageContent': $("#message").val()}));
}

var sendPrivateMessage = () => {
    // send private message.
    console.log('呼叫 sendPrivateMessage');

    stompClient.send("/ws/private-message", {}, JSON.stringify({'messageContent': $("#private-message").val()}));
}

var updateNotificationAndDisplay = () => {
    // update the value of notification.
    console.log('呼叫 sendPrivateMessage');

    if (notificationCount == 0) {
        $('#notifications').hide();
    } else {
        $('#notifications').show();
        $('#notifications').text(notificationCount);
    }
}

var resetNotificationCount = () => {
    // reset the value of notification.
    console.log('呼叫 resetNotificationCount');

    notificationCount = 0;
    updateNotificationAndDisplay();
}