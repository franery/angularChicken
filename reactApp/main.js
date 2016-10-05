import React from 'react';
import ReactDOM from 'react-dom';
import {Router, Route, browserHistory, IndexRoute} from 'react-router';
import App from './App.jsx';
import MultiplexorApp from './MultiplexorApp.jsx';

import {Home, About, Contact, Tabla} from './App.jsx';

ReactDOM.render((
   <Router history = {browserHistory}>
      <Route path = "/" component = {App}>
         <IndexRoute component = {About} />
         <Route path = "home" component = {Home} />
         <Route path = "about" component = {About} />
         <Route path = "contact" component = {Contact} />
         <Route path = "tabla" component = {Tabla} />
         <Route path = "multiplexor" component = {MultiplexorApp} />
      </Route>
   </Router>
), document.getElementById('app'));