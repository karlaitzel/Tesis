// Botones para iniciar y detener la transmision y capturar la imagen 
var btnStart = document.getElementById( "btn-start" );
var btnStop = document.getElementById( "btn-stop" );
var btnCapture = document.getElementById( "btn-capture" );

// Transmision y captura 
var stream = document.getElementById( "Camara" );
var capture = document.getElementById( "Captura" );
var snapshot = document.getElementById( "Imagen" );

// Camara de video
var cameraStream = null;

// Attach listeners
btnStart.addEventListener( "click", startStreaming );
btnStop.addEventListener( "click", stopStreaming );
btnCapture.addEventListener( "click", captureSnapshot );

// Inicio de la camara 
function startStreaming() {

    var mediaSupport = 'mediaDevices' in navigator;

    if( mediaSupport && null == cameraStream ) {

        navigator.mediaDevices.getUserMedia( { video: true } )
        .then( function( mediaStream ) {

            cameraStream = mediaStream;

            stream.srcObject = mediaStream;

            stream.play();
        })
        .catch( function( err ) {

            console.log( "No se puede acceder a la cámara: " + err );
        });
    }
    else {

        alert( 'No es compatible' );

        return;
    }
}

// Alto de la camara 
function stopStreaming() {

    if( null != cameraStream ) {

        var track = cameraStream.getTracks()[ 0 ];

        track.stop();
        stream.load();

        cameraStream = null;
    }
}

function captureSnapshot() {

    if( null != cameraStream ) {

        var ctx = capture.getContext( '2d' );
        var img = new Image();

        ctx.drawImage( stream, 0, 0, capture.width, capture.height );
    
        img.src     = capture.toDataURL( "image/png" );
        img.width   = 240;

        snapshot.innerHTML = '';

        snapshot.appendChild( img );
    }
}