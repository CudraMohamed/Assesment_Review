package cudra.mohamed.assesment_rev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cudra.mohamed.assesment_rev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleClick()
    }
    fun handleClick(){
        binding.btnAdd.setOnClickListener {
            add(obtainInputs())
        }
        binding.btnSubtract.setOnClickListener {
                subtract(obtainInputs())
        }
        binding.btnModulus.setOnClickListener {
                modulus(obtainInputs())
        }
        binding.btnDivision.setOnClickListener {
                division(obtainInputs())
        }
    }

    data class Inputs(var num1: Double,var  num2: Double)

    fun obtainInputs():Inputs?{
        binding.tilNum1.error=null
        val num1=binding.etNum1.text.toString()
        val num2=binding.etNumb2.text.toString()
        var error=false

        if (num1.isBlank()){
           binding.tilNum1.error="Number 1 is required"
            error=true
        }
        if (num2.isBlank()){
            binding.tilNumb2.error="Number 2 is required"
            error=true
        }

        if(!error){
            return Inputs(num1.toDouble(),num2.toDouble())
        }
        return null
    }

    fun add(inputs:Inputs?){
        if(inputs!=null){
            displayResult(inputs.num1+inputs.num2)
        }
    }
    fun subtract(inputs:Inputs?){
       if(inputs!=null){
           displayResult(inputs.num1-inputs.num2)
       }
    }
    fun modulus(inputs:Inputs?){
        if(inputs!=null){
            displayResult(inputs.num1%inputs.num2)
        }
    }
    fun division(inputs:Inputs?){
        if(inputs!=null){
            displayResult(inputs.num1/inputs.num2)
        }
    }
    fun displayResult(result:Double){
        binding.tvResults.text=result.toString()
    }
}