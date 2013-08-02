console.log('send.js loaded');

var jqueryLoad = document.createElement('script');
jqueryLoad.setAttribute('type','text/javascript');
jqueryLoad.setAttribute('charset','UTF-8');
jqueryLoad.setAttribute('src','http://localhost:8080/LinkCollector/resources/js/jquery.min.js');
document.body.appendChild(jqueryLoad);
console.log('jquery.js loaded');


var avgrundStyle = document.createElement('link');
avgrundStyle.setAttribute('rel','stylesheet');
avgrundStyle.setAttribute('href','http://localhost:8080/LinkCollector/resources/css/style.css');
document.body.appendChild(avgrundStyle);


console.log('avgrund.css  style loaded');

var avgrundCss = document.createElement('link');
avgrundCss.setAttribute('rel','stylesheet');
avgrundCss.setAttribute('href','http://localhost:8080/LinkCollector/resources/css/avgrund.css');
document.body.appendChild(avgrundCss);

var checkReady = function(callback) {
    if (window.sendItJQ) {
        console.log('sendItJQ loaded');
        callback(sendItJQ);
        senditScriptloaded = true;
    }
    else {
        window.setTimeout(function() { checkReady(callback); }, 100);
    }
};

// Start polling...
checkReady(function(sendItJQ) {
    var avgrund = {
        body :sendItJQ('body'),
        options : {
            width: 380, // max = 640
            height: 280, // max = 350
            showClose: false,
            showCloseText: '',
            closeByEscape: true,
            closeByDocument: true,
            holderClass: '',
            overlayClass: '',
            enableStackAnimation: false,
            onBlurContainer: '',
            openOnEvent: true,
            setEvent: 'click',
            onLoad: false,
            onUnload: false,
            template: '<p>This is test popin content!</p>'
        },
        activate : function()
        {
            if (typeof   avgrund.options.onLoad === 'function') {
                avgrund.options.onLoad(self);
            }


            setTimeout(function() {
                avgrund.body.addClass('avgrund-active');
            }, 100);



            avgrund.body.append('<div class="avgrund-popin ' + avgrund.options.holderClass + '">' + avgrund.options.template + '</div>');
            sendItJQ('.avgrund-popin').css({
                'width': avgrund.options.maxWidth  + 'px',
                'height': avgrund.options.maxHeight + 'px',
                'margin-left': '-' + ( avgrund.options.maxWidth / 2 + 10) + 'px',
                'margin-top': '-' + (avgrund.options.maxHeight / 2 + 10) + 'px'
            });



            if (avgrund.options.showClose) {
                sendItJQ('.avgrund-popin').append('<a href="#" class="avgrund-close">' + avgrund.options.showCloseText + '</a>');
            }

            if (avgrund.options.enableStackAnimation) {
                sendItJQ('.avgrund-popin').addClass('stack');
            }

            avgrund.body.bind('keyup', avgrund.onDocumentKeyup);
            avgrund.body.bind('click', avgrund.onDocumentClick);

        }
        ,
        onDocumentKeyup: function(e) {
            if (avgrund.options.closeByEscape) {
                if (e.keyCode === 27) {
                    avgrund.deactivate();
                }
            }
        },

        onDocumentClick :function  (e) {
            if (avgrund.options.closeByDocument) {
                if (sendItJQ(e.target).is('.avgrund-overlay, .avgrund-close')) {
                    e.preventDefault();
                    avgrund.deactivate();
                }
                if (sendItJQ(e.target).is('.sendit')) {
                    console.log('sended it');
                    sendItJQ.ajax({
                        url:"http://localhost:8080/LinkCollector/restcontainer",
                        type: "POST",
                        crossDomain :true,
                        dataType: 'jsonp',
                        data: {
                            user: {
                              username: 'jdoe',
                              display_name: 'John Doe',
                              password: 'secret',
                              kind: 'Instructor',
                              metadata: {
                                'hair colour': 'Brown'
                              }
                            }
                          }
                    });
                    e.preventDefault();
                    avgrund.deactivate();
                }
            } else {
                if (sendItJQ(e.target).is('.avgrund-close')) {
                    e.preventDefault();
                    avgrund.deactivate();
                }

            }
        } ,

        deactivate : function  () {
            avgrund.body.unbind('keyup', avgrund.onDocumentKeyup);
            avgrund.body.unbind('click', avgrund.onDocumentClick);

            avgrund.body.removeClass('avgrund-active');

            setTimeout(function() {
                sendItJQ('.avgrund-popin').remove();
                sendItJQ('.avgrund-overlay').remove();

            }, 500);

            if (typeof avgrund.options.onUnload === 'function') {
                avgrund.options.onUnload(self);
            }
        } ,
        init : function (options) {
            console.log("init send it");

            sendItJQ('.avgrund-popin').remove();
            sendItJQ('.avgrund-overlay').remove();


            avgrund.options = sendItJQ.extend(avgrund.options, options);

            avgrund.options.maxWidth = avgrund.options.width > 640 ? 640 : avgrund.options.width;
            avgrund.options.maxHeight = avgrund.options.height > 350 ? 350 : avgrund.options.height;


            avgrund.body.addClass('avgrund-ready');
            avgrund.body.append('<div class="avgrund-overlay ' + avgrund.options.overlayClass + '"></div>');

            if (avgrund.options.onBlurContainer !== '') {
                sendItJQ(avgrund.options.onBlurContainer).addClass('avgrund-blur');
            }

            avgrund.activate();
        }
    };

    avgrund.init({
        height: 200,
        width: 500,
        holderClass: 'sendit-custom',
        showClose: true,
        showCloseText: 'close',
        onBlurContainer: '.sendit-container',
        template: '<p>Send It to your container</p>' +
            '<div>' +
            '<a href="#" class="sendit">Send It!</a>' +
            '<a href="http://pausecaca.com" class="twitter">Dont put it in the history!</a>' +
            '<a href="http://pixefolio.com" class="github">Go to your container page</a>' +
            '</div>'
    });

});



