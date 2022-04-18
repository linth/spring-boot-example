var stompClient = null;

/**
 * set up UI layout when the link is connected.
 * @param {*} connected 
 */
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    } else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

/**
 * connect procedure.
 */
function connect() {
    var socket = new SockJS('/stomp-endpoint');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body));
        });
    });
}

/**
 * disconnect procedure.
 */
function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

/**
 * set up the name.
 */
function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

/**
 * show greeting information.
 * @param {*} message 
 */
function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message.message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); }); // click connect button.
    $( "#disconnect" ).click(function() { disconnect(); }); // click disconnect button.
    $( "#send" ).click(function() { sendName(); }); // click the send button.
});