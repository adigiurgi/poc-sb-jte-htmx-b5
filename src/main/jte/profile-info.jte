@param String contextPath
@param com.example.webapp.infrastructure.config.security.UserActiveProfileProvider profile

<!DOCTYPE html>
<html lang="ro">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Informații profil</title>
    <link rel="stylesheet" href="${contextPath}/css/vendor/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <div class="card">
                    <div class="card-header bg-primary text-white">
                        <h4>Profilul utilizatorului curent</h4>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <tr>
                                    <th>ID Profil Activ:</th>
                                    <td>${profile.getId()}</td>
                                </tr>
                                <tr>
                                    <th>ID Utilizator:</th>
                                    <td>${profile.getIdUser()}</td>
                                </tr>
                                <tr>
                                    <th>Nume utilizator:</th>
                                    <td>${profile.getUsername()}</td>
                                </tr>
                                <tr>
                                    <th>ID Profil:</th>
                                    <td>${profile.getIdProfile()}</td>
                                </tr>
                                <tr>
                                    <th>Nume profil:</th>
                                    <td>${profile.getProfileName()}</td>
                                </tr>
                                <tr>
                                    <th>Creat la:</th>
                                    <td>${String.valueOf(profile.getInsertedAt())}</td>
                                </tr>
                            </table>
                        </div>
                        <div class="mt-3">
                            <a href="${contextPath}/" class="btn btn-primary">Înapoi la pagina principală</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
