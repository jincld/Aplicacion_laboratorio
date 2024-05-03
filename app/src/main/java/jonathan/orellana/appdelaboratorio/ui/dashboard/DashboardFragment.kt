package jonathan.orellana.appdelaboratorio.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import jonathan.orellana.appdelaboratorio.MainActivity
import jonathan.orellana.appdelaboratorio.R
import jonathan.orellana.appdelaboratorio.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View {


        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it

            //toast

            val btnNombre = root.findViewById<Button>(R.id.btnNombre)
            btnNombre.setOnClickListener {
                Toast.makeText(context,"Jonathan Orellana",Toast.LENGTH_SHORT).show()
            }

        }
        return root

    }


    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null

    }
}