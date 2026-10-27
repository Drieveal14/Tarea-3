package com.example.tarea_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<ProductoCafe> productos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarProductos();

        ListView listaProductos = findViewById(R.id.listaProductos);
        ProductoAdapter adapter = new ProductoAdapter(productos);
        listaProductos.setAdapter(adapter);

        listaProductos.setOnItemClickListener((parent, view, position, id) -> {
            ProductoCafe productoSeleccionado = productos.get(position);
            String mensaje = getString(
                    R.string.mensaje_seleccion,
                    productoSeleccionado.getNombre(),
                    productoSeleccionado.getPrecio()
            );

            Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
        });
    }

    private void cargarProductos() {
        productos.add(new ProductoCafe(
                getString(R.string.espresso_nombre),
                getString(R.string.espresso_descripcion),
                42.00,
                R.drawable.ic_espresso
        ));

        productos.add(new ProductoCafe(
                getString(R.string.americano_nombre),
                getString(R.string.americano_descripcion),
                48.00,
                R.drawable.ic_americano
        ));

        productos.add(new ProductoCafe(
                getString(R.string.capuchino_nombre),
                getString(R.string.capuchino_descripcion),
                62.00,
                R.drawable.ic_capuchino
        ));

        productos.add(new ProductoCafe(
                getString(R.string.latte_nombre),
                getString(R.string.latte_descripcion),
                65.00,
                R.drawable.ic_latte
        ));

        productos.add(new ProductoCafe(
                getString(R.string.moka_nombre),
                getString(R.string.moka_descripcion),
                72.00,
                R.drawable.ic_moka
        ));

        productos.add(new ProductoCafe(
                getString(R.string.chai_nombre),
                getString(R.string.chai_descripcion),
                68.00,
                R.drawable.ic_chai
        ));

        productos.add(new ProductoCafe(
                getString(R.string.croissant_nombre),
                getString(R.string.croissant_descripcion),
                45.00,
                R.drawable.ic_croissant
        ));

        productos.add(new ProductoCafe(
                getString(R.string.pastel_nombre),
                getString(R.string.pastel_descripcion),
                58.00,
                R.drawable.ic_pastel
        ));
    }

    private static class ProductoCafe {
        private final String nombre;
        private final String descripcion;
        private final double precio;
        private final int imagen;

        ProductoCafe(
                String nombre,
                String descripcion,
                double precio,
                int imagen
        ) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.imagen = imagen;
        }

        String getNombre() {
            return nombre;
        }

        String getDescripcion() {
            return descripcion;
        }

        double getPrecio() {
            return precio;
        }

        int getImagen() {
            return imagen;
        }
    }


    private class ProductoAdapter extends ArrayAdapter<ProductoCafe> {

        ProductoAdapter(List<ProductoCafe> productos) {
            super(MainActivity.this, R.layout.item_producto_cafe, productos);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.item_producto_cafe, parent, false);

                holder = new ViewHolder();
                holder.imagen = convertView.findViewById(R.id.imagenProducto);
                holder.nombre = convertView.findViewById(R.id.textoNombre);
                holder.descripcion = convertView.findViewById(R.id.textoDescripcion);
                holder.precio = convertView.findViewById(R.id.textoPrecio);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            ProductoCafe producto = getItem(position);
            if (producto != null) {
                holder.imagen.setImageResource(producto.getImagen());
                holder.imagen.setContentDescription(producto.getNombre());
                holder.nombre.setText(producto.getNombre());
                holder.descripcion.setText(producto.getDescripcion());
                holder.precio.setText(
                        getString(R.string.formato_precio, producto.getPrecio())
                );
            }

            return convertView;
        }
    }

    private static class ViewHolder {
        ImageView imagen;
        TextView nombre;
        TextView descripcion;
        TextView precio;
    }
}
