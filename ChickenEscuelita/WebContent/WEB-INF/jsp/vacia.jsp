<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>primera pagina</title>
</head>
<body>

<br>
<br>
<!-- <div id="accordion" role="tablist" aria-multiselectable="true"> -->
<!--   <div class="panel panel-default"> -->
<!--     <div class="panel-heading" role="tab" id="headingOne"> -->
<!--       <h4 class="panel-title"> -->
<!--         <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"> -->
<!--           Collapsible Group Item #1 -->
<!--         </a> -->
<!--       </h4> -->
<!--     </div> -->
<!--     <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne"> -->
<!--       Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS. -->
<!--     </div> -->
<!--   </div> -->
<!--   <div class="panel panel-default"> -->
<!--     <div class="panel-heading" role="tab" id="headingTwo"> -->
<!--       <h4 class="panel-title"> -->
<!--         <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo"> -->
<!--           Collapsible Group Item #2 -->
<!--         </a> -->
<!--       </h4> -->
<!--     </div> -->
<!--     <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo"> -->
<!--       Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS. -->
<!--     </div> -->
<!--   </div> -->
<!--   <div class="panel panel-default"> -->
<!--     <div class="panel-heading" role="tab" id="headingThree"> -->
<!--       <h4 class="panel-title"> -->
<!--         <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree"> -->
<!--           Collapsible Group Item #3 -->
<!--         </a> -->
<!--       </h4> -->
<!--     </div> -->
<!--     <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree"> -->
<!--       Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS. -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->
<h1>Basic Example</h1>
    <div id="container">
      <p>
        To install React, follow the instructions on
        <a href="https://github.com/facebook/react/">GitHub</a>.
      </p>
      <p>
        If you can see this, React is <strong>not</strong> working right.
        If you checked out the source from GitHub make sure to run <code>grunt</code>.
      </p>
    </div>
    
<%--     <script type="text/babel" src="${pageContext.request.contextPath}/react/main.js"></script> --%>
	<script>
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
	
	</script>
    <h4>Example Details</h4>
    <p>This is written in vanilla JavaScript (without fssfJSX) and transformed in the browser.</p>
    <p>
      Learn more about React at
      <a href="https://facebook.github.io/react" target="_blank">facebook.github.io/react</a>.
    </p>
    
<br>
<br>
<br>
<br>

</body>
</html>