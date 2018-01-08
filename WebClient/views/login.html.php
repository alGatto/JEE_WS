<div class="row valign-wrapper lighten-2" style="height: 100vh;margin-bottom:0">
    <form class="col s12 center valign" method="POST" action="<?php echo url_for('/login')?>">
        <h1 class="cyan-text">LibraryProject</h1>
        <div class="row">
            <div class="input-field col m4 offset-m4 s12">
                <span class="left-align cyan-text" style="width: 100%">Login</span>
                <input id="login" name="login" required type="text" class=" white">
            </div>
        </div>
        <div class="row">
            <div class="input-field col m4 offset-m4 s12">
                <span class="left-align cyan-text" style="width: 100%">Mot de passe</span>
                <input id="password" required name="password" type="password" class="validate white">
            </div>
        </div>
        <?php if(isset($error) && boolval($error)){?>
    <span class="red-text row">Une erreur est survenue, veuillez vérifier vos identifiants ou réessayer ultérieurement.</span>
<?php }?>
<button class="btn waves-effect waves-light lighten-2 darken-4 row center" type="submit" name="action">Connexion
    <i class="fa fa-check"></i>
</button>
<a class="btn waves-effect waves-light lighten-2 darken-4 row center" href="<?php echo url_for('/register')?>" name="action">Inscription
    <i class="fa fa-user-plus"></i>
</a>
</form>
</div>