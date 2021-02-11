<body>
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">BLUZEN CMS</a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="logout">Sign out</a>
    </li>
  </ul>
</nav>

    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="sidebar-sticky pt-3">
      	<h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          <span>Systems</span>
        </h6>
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link" href="dashboard">
              <span class="feather-monitor"></span>
              Dashboard <span class="sr-only"></span>
            </a>
          </li>
          <c:set var = "Level" value = "${Security}"/>
          <c:if test = "${Level < 1}">
          <li class="nav-item">
            <a class="nav-link" href="hardware">
              <span class="feather-activity"></span>
              Hardware
            </a>
          </li>
          </c:if>
          <c:set var = "Level" value = "${Security}"/>
          <c:if test = "${Level < 6}">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="feather-search"></span>
              Search
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            	<a class="dropdown-item" href="searchWorker">
	            	<span class="feather-user"></span>
	            	Worker Information
            	</a>
            	<div class="dropdown-divider"></div>
            	<a class="dropdown-item" href="searchIO">
            		<span class="feather-watch"></span>
            		In Out History
            	</a>
            </div>
          </li>
          </c:if>
        </ul>
		<c:set var = "Level" value = "${Security}"/>
        <c:if test = "${Level < 5}">
        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          <span>Settings</span>
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item">
            <a class="nav-link" href="addAccount">
              <span class="feather-user-plus"></span>
              Create Account
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="mgruser">
              <span class="feather-users"></span>
              Management Account
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="camp">
              <span class="feather-home"></span>
              Management Camp
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="nationality">
              <span class="feather-circle"></span>
              Management Nationality
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="position">
              <span class="feather-disc"></span>
              Management Position
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="company">
              <span class="feather-layers"></span>
              Management Company
            </a>
          </li>
        </ul>
        </c:if>
      </div>
    </nav>