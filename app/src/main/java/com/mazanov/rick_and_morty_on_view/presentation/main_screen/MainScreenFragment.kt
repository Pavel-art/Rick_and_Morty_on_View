package com.mazanov.rick_and_morty_on_view.presentation.main_screenimport android.os.Bundleimport android.view.LayoutInflaterimport android.view.Viewimport android.view.ViewGroupimport androidx.fragment.app.Fragmentimport com.mazanov.rick_and_morty_on_view.databinding.MainScreenFragmentBindingclass MainScreenFragment : Fragment() {    private var _binding: MainScreenFragmentBinding? = null    private val binding: MainScreenFragmentBinding        get() = _binding ?: throw RuntimeException("MainScreenFragmentBinding == null")    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)    }    override fun onCreateView(        inflater: LayoutInflater, container: ViewGroup?,        savedInstanceState: Bundle?    ): View {        _binding = MainScreenFragmentBinding.inflate(inflater, container, false)        return binding.root    }    override fun onDestroy() {        super.onDestroy()        _binding = null    }}