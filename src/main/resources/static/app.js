var stompClient = null;

function connect() {
	var socket = new SockJS(getBaseUrl() + "/gs-guide-websocket");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe("/topic/public", function (command) {
        	console.info("received url: " + JSON.parse(command.body).argument);
            addUrlToTheList(JSON.parse(command.body).argument);
        });
    });
}

function getBaseUrl() {
	var url = window.location;
	var baseUrl = url.protocol + "//" + url.host + "/" + url.pathname.split('/')[1];
	return baseUrl;
}

function addUrlToTheList(url) {
	if (!isExisted("list-url")) {
		$("#play-list").append("<ul id='list-url'></ul>");
	}
	$("#list-url").append("<li>" + url + "</li>");
	playUrl(url);
}

function isExisted(elementId) {
	return $("#" + elementId).length != 0;
}

function addUrl() {
	var nickname = $("#nickname").val();
	var url = $("#music-url").val();

	var command = {
		sender : nickname,
		commandType : "ADD_URL",
		argument : url
	};

	stompClient.send(
			"/app/add-url",
			{},
			JSON.stringify(command));
}

function playUrl(url) {
	if (wantToPlayStatusValue) {
		$("#player").attr("src", url);
	}
}

var wantToPlayStatusValue = false;

$(function () {
	connect();
	$("#add-music-url").click(addUrl);

	$('#want-to-play').change(function() {
		wantToPlayStatusValue = $('#want-to-play').is(":checked");
	});
});