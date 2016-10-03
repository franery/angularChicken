//<script src="${pageContext.request.contextPath}/js/react.js"></script>
//<script src="${pageContext.request.contextPath}/js/react-dom.min.js"></script>
//<script src="${pageContext.request.contextPath}/js/react-dom-server.min.js"></script>
//<script src="${pageContext.request.contextPath}/js/react-with-addons.min.js"></script>
//import React from 'js/react';
//import {React;} from "js/react";
//import {React;} from "js/react.js";
//import {ReactDOM;} from "js/react-dom";
//import {ReactDOM;} from "js/react-dom.js";
//import ReactDOM from 'react-dom';

var ExampleApplication = React.createClass({
  render: function() {
    var elapsed = Math.round(this.props.elapsed  / 100);
    var seconds = elapsed / 10 + (elapsed % 10 ? '' : '.0' );
    var message =
      'React has been successfully running for ' + seconds + ' seconds.';

    return React.DOM.p(null, message);
  }
});

// Call React.createFactory instead of directly call ExampleApplication({...}) in React.render
var ExampleApplicationFactory = React.createFactory(ExampleApplication);

var start = new Date().getTime();
setInterval(function() {
  ReactDOM.render(
    ExampleApplicationFactory({elapsed: new Date().getTime() - start}),
    document.getElementById('container')
  );
}, 50);
