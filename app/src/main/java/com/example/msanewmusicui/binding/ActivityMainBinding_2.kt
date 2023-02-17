//import android.R
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.annotation.Nullable
//import com.example.msanewmusicui.core.databinding.ItemListAnimeBinding.bind
//
//
//fun inflate(inflater: LayoutInflater): ActivityMainBinding {
//    return inflate(inflater, null, false)
//}
//
//fun inflate(
//    inflater: LayoutInflater,
//    @Nullable parent: ViewGroup?, attachToParent: Boolean
//): ActivityMainBinding {
//    val root: View = inflater.inflate(R.layout.activity_main, parent, false)
//    if (attachToParent) {
//        parent!!.addView(root)
//    }
//    return bind(root)
//}