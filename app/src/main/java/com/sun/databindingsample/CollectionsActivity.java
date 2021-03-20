package com.sun.databindingsample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;

import com.sun.databindingsample.databinding.ActivityCollectionsBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Expression language about Collections
 *
 * @author sxl
 * @date 2018/7/22 18:00
 */
public class CollectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        SparseArray<String> sparse = new SparseArray<>();
        sparse.put(0, "AAA");
        sparse.put(1, "BBB");
        sparse.put(2, "CCC");

        Map<String, String> map = new HashMap<>();
        map.put("data", "Data");
        map.put("binding", "Binding");

        int index = 1;
        String key = "binding";

        ActivityCollectionsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_collections);
        binding.setList(list);
        binding.setSparse(sparse);
        binding.setMap(map);
        binding.setIndex(index);
        binding.setKey(key);
    }
}
