package com.cerana.cerana.gui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cerana.cerana.R;
import com.cerana.cerana.negocio.SessaoUsuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PerfilActivity extends AppCompatActivity {

    private TextView tvNome;
    private TextView tvNperguntas;
    private TextView tvTags;
    private ImageView imvPerfil;
    private TextView tvBio;

    public static int IMAGE_GALLERY_REQUEST = 20;

    private SessaoUsuario sessaoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tvNome = (TextView)findViewById(R.id.tv_nome);
        tvNperguntas = (TextView)findViewById(R.id.tv_perguntas);
        imvPerfil = (ImageView)findViewById(R.id.imv_perfil);
        tvBio = (TextView) findViewById(R.id.tv_bio);

        sessaoUsuario = new SessaoUsuario(getApplicationContext());
        sessaoUsuario.iniciarSessao(getApplicationContext());

        setTextos();


    }



    public void setTextos(){
        String pessoa = sessaoUsuario.getUsuarioLogado().getNome();
        if (!(pessoa == null)){
            tvNome.setText(sessaoUsuario.getUsuarioLogado().getNome());
            tvNperguntas.setText("0");
            tvBio.setText(sessaoUsuario.getUsuarioLogado().getDescricao());

        }

    }

    public void onImageGalleryClicked(View v){
        Intent photoPickerIntent = new Intent((Intent.ACTION_PICK));

        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureDirectoryPath = pictureDirectory.getPath();

        Uri data = Uri.parse(pictureDirectoryPath);

        photoPickerIntent.setDataAndType(data, "image/*");

        startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);
    }

    protected void onActivityResult(int requestcode, int resultCode, Intent data){
        if (resultCode == RESULT_OK){
            if (requestcode == IMAGE_GALLERY_REQUEST){
                Uri imageUri = data.getData();

                InputStream inputStream;

                try {
                    inputStream = getContentResolver().openInputStream(imageUri);
                    Bitmap image = BitmapFactory.decodeStream(inputStream);
                    imvPerfil.setImageBitmap(image);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                    Toast.makeText(this, "Unable to open image", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void starHomeActivity(View view){
        startActivity(new Intent(this, TelaInicialActivity.class));
        finish();
    }

    public void startEditarPerfilActivity(View view){
        startActivity(new Intent(this, EditarPerfilActivity.class));
        finish();
    }

}
