package thiagocury.eti.br.exemplomaterialdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class TelaAbertura extends AppCompatActivity {

    //Menu
    private Drawer result = null;

    //Toolbar
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_abertura);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Masss ahhh!!!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //##MENU
        //Com o cabeçalho
        //####################### SÓ O CABEÇALHO #######################
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.sky)
                .addProfiles(
                        //new ProfileDrawerItem().withName("Thiago Cury").withEmail("thiagocury@gmail.com").withIcon(R.mipmap.ic_launcher)
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener(){
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        //Menu
        //####################### SÓ O MENU #######################
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                //.withSelectedItem(10) //criar sem deixar pré selecionado
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Home").withIdentifier(0).withIcon(R.mipmap.ic_launcher),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("Tela 1").withIdentifier(10).withIcon(R.mipmap.ic_launcher),
                        new PrimaryDrawerItem().withName("Tela 2").withIdentifier(20).withIcon(R.mipmap.ic_launcher),
                        new PrimaryDrawerItem().withName("Sair").withIdentifier(999).withIcon(R.mipmap.ic_launcher))
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        switch ((int)drawerItem.getIdentifier()) {
                            case 10:
                                Intent it = new Intent(TelaAbertura.this,Tela1.class);
                                startActivity(it);
                                break;

                            case 20:
                                Intent it20 = new Intent(TelaAbertura.this,Tela2.class);
                                startActivity(it20);
                                break;

                            case 999:
                                finish();
                                break;
                        }//fecha switch

                        return false;
                    }
                }).withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View view) {
                    }
                    @Override
                    public void onDrawerClosed(View view) {
                    }
                    @Override
                    public void onDrawerSlide(View view, float v) {
                    }
                })
                .build();
    }//fecha onCreate
}//fecha classe