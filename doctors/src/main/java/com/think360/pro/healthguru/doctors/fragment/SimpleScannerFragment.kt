package com.think360.pro.healthguru.doctors.fragment

/**
 * Created by think360 on 21/09/17.
 */
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.google.zxing.Result
import com.think360.pro.healthguru.doctors.R

import me.dm7.barcodescanner.zxing.ZXingScannerView

class SimpleScannerFragment : Fragment(), ZXingScannerView.ResultHandler {
    private var mScannerView: ZXingScannerView? = null
    companion object {
        fun newInstance(): SimpleScannerFragment {
            return SimpleScannerFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val  view  = inflater?.inflate( R.layout.simple_scanner_fragment, container, false)
        mScannerView = view?.findViewById(R.id.scannerView);
        return view
    }

    override fun onResume() {
        super.onResume()
        mScannerView!!.setResultHandler(this)
        mScannerView!!.startCamera()
    }

    override fun handleResult(rawResult: Result) {
        Toast.makeText(activity, "Contents = " + rawResult.text +
                ", Format = " + rawResult.barcodeFormat.toString(), Toast.LENGTH_SHORT).show()
        // Note:
        // * Wait 2 seconds to resume the preview.
        // * On older devices continuously stopping and resuming camera preview can result in freezing the app.
        // * I don't know why this is the case but I don't have the time to figure out.
        val handler = Handler()
        handler.postDelayed({ mScannerView!!.resumeCameraPreview(this@SimpleScannerFragment) }, 2000)
    }

    override fun onPause() {
        super.onPause()
        mScannerView!!.stopCamera()
    }
}