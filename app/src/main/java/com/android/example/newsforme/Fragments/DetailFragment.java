package com.android.example.newsforme.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.newsforme.Activities.HomeActivity;
import com.android.example.newsforme.Data.Json_data_sources;
import com.android.example.newsforme.R;
import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.github.florent37.shapeofview.shapes.DiagonalView;

import de.hdodenhof.circleimageview.CircleImageView;


public class DetailFragment extends Fragment {

    private DiagonalView diagonalView;
    private TextView titleTv;
    private TextView contentTv;
    private ImageView detailIv;
    private TextView urlTv;
    private TextView sourceTv;
    private TextView authorTv;
    private TextView publishedAtTv;
    private TextView descriptionTv;
    private TextView categoryTv;
    private CircleImageView circleImageView;
    private KenBurnsView kenBurnsView;
    private Button linkButton;
    private Json_data_sources json_data_sources;


    private String title;
    private String imageUrl;
    private String content;
    private String author;
    private String source;
    private String url;
    private String publishedAt;
    private String category;
    private String description;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        kenBurnsView = view.findViewById(R.id.kenBurnsView);
        categoryTv = view.findViewById(R.id.detailCategoryTv);
        titleTv = view.findViewById(R.id.detailTitleTv);
        circleImageView = view.findViewById(R.id.detailCircleImageView);
        authorTv = view.findViewById(R.id.detailAuthorTv);
        contentTv = view.findViewById(R.id.detailContentTv);
        linkButton = view.findViewById(R.id.linkButton);
//        publishedAtTv = view.findViewById(R.id.detailPublishedTv);
        descriptionTv = view.findViewById(R.id.detailDescriptionTv);
        Log.d("Arguments", getArguments().toString());
//        Log.d("Content", getArguments().getString("content"));
        if (getArguments() == null) {
            Toast.makeText(getContext(), "ARGUMENTS IS NULL", Toast.LENGTH_LONG);
        } else {
            categoryTv.setText(getArguments().getString("category"));
            descriptionTv.setText(getArguments().getString("description"));
//            publishedAtTv.setText(getArguments().getString("publishedAt"));
            authorTv.setText(getArguments().getString("source"));
            titleTv.setText(getArguments().getString("title"));
            setImageViewResource(circleImageView);
            Glide.with(getContext())
                    .load(getArguments().getString("imageView"))
                    .into(kenBurnsView);
            if (getArguments().getString("content") != null)
                contentTv.setText(getArguments().getString("content"));
            else
                Toast.makeText(getContext(), "There's no content, sorry", Toast.LENGTH_SHORT).show();

            linkButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = getArguments().getString("url");

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
            });

            circleImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(getActivity());
        }

        return super.onOptionsItemSelected(item);
    }

    public CircleImageView setImageViewResource (CircleImageView circleImageView){
        if (getArguments().getString("source").equals("CNN")) circleImageView.setImageResource(R.drawable.ic_cnn);
        else if (getArguments().getString("source").equals("Bbc.com") || getArguments().getString("source").equals("BBC Sport")) circleImageView.setImageResource(R.drawable.ic_bbc);
        else if (getArguments().getString("source").equals("Youtube.com")) circleImageView.setImageResource(R.drawable.ic_youtube);
        else if (getArguments().getString("source").equals("Fox News")) circleImageView.setImageResource(R.drawable.ic_fox);
        else if (getArguments().getString("source").equals("Yahoo.com")) circleImageView.setImageResource(R.drawable.ic_yahoo);
        else if (getArguments().getString("source").equals("Apple.com")) circleImageView.setImageResource(R.drawable.ic_apple);
        else if (getArguments().get("source").equals("The New York Times")) Glide.with(getActivity())
                .load("https://www.nytimes.com/vi-assets/static-assets/apple-touch-icon-319373aaf4524d94d38aa599c56b8655.png").into(circleImageView);
        else if (getArguments().get("source").equals("ABC News")) Glide.with(getActivity())
                .load("https://s.abcnews.com/assets/images/apple-touch-icons/touch-icon-ipad-retina.png").into(circleImageView);
        else if (getArguments().get("source").equals("ABC News (AU)")) Glide.with(getActivity())
                .load("https://mobile.abc.net.au/homepage/mobile/images/homepage/apple-touch-icon-144x144.png").into(circleImageView);
        else if (getArguments().get("source").equals("Aftenposten")) Glide.with(getActivity())
                .load("https://www.aftenposten.no/public/apple-touch-icon-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("Al Jazeera English")) Glide.with(getActivity())
                .load("https://www.aljazeera.com/assets/images/touch-icon-iphone-retina.png").into(circleImageView);
        else if (getArguments().get("source").equals("ANSA.it")) Glide.with(getActivity())
                .load("http://www.ansa.it/sito/img/ico/ansa-144-precomposed.png").into(circleImageView);
        else if (getArguments().get("source").equals("Argaam")) Glide.with(getActivity())
                .load("https://www.argaam.com/apple-touch-icon-precomposed.png").into(circleImageView);
        else if (getArguments().get("source").equals("Ars Technica")) Glide.with(getActivity())
                .load("http://cdn.arstechnica.net/apple-touch-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("Ary News")) Glide.with(getActivity())
                .load("https://arynews.tv/wp-content/uploads/2018/07/apple-icon-144x144.png").into(circleImageView);
        else if (getArguments().get("source").equals("Associated Press")) Glide.with(getActivity())
                .load("https://apnews.com/branding/favicon/128.png").into(circleImageView);
        else if (getArguments().get("source").equals("Australian Financial Review")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/A-120-0089d0.png").into(circleImageView);
        else if (getArguments().get("source").equals("Axios")) Glide.with(getActivity())
                .load("https://assets.axios.com/icons-023b31e91db1f3ed6ba6184b3117b001/apple-touch-icon-120x120.png").into(circleImageView);
//        else if (getArguments().get("source").equals("BBC News")) Glide.with(getActivity())
//                .load("https://cf3e497594.site.internapcdn.net/tmpl/v6/img/logo-header.png").into(circleImageView);
//        else if (getArguments().get("source").equals("BBC Sport")) Glide.with(getActivity())
//                .load("https://cf3e497594.site.internapcdn.net/tmpl/v6/img/logo-header.png").into(circleImageView);
        else if (getArguments().get("source").equals("Bild")) Glide.with(getActivity())
                .load("https://bilder.bild.de/fotos/bild-de-35605834/Bild/3.bild.png").into(circleImageView);
        else if (getArguments().get("source").equals("Blasting News (BR)")) Glide.with(getActivity())
                .load("https://srs1.blastingcdn.com/images/apple-touch-icons/touch-icon-iphone-retina.png").into(circleImageView);
        else if (getArguments().get("source").equals("Bleacher Report")) Glide.with(getActivity())
                .load("https://www.bleacherreport.com/img/favicon/appleTouchIcon.png").into(circleImageView);
        else if (getArguments().get("source").equals("Bloomberg")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/B-120.png").into(circleImageView);
        else if (getArguments().get("source").equals("Breitbart News")) Glide.with(getActivity())
                .load("https://www.breitbart.com/apple-touch-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("Business Insider")) Glide.with(getActivity())
                .load("https://media.businessinsider.com/public/assets/BI/US/favicons/apple-touch-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("Business Insider (UK)")) Glide.with(getActivity())
                .load("https://media.businessinsider.com/public/assets/BI/US/favicons/apple-touch-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("Buzzfeed")) Glide.with(getActivity())
                .load("https://www.buzzfeed.com/static-assets/img/touch-icon-ios_120.208a0e329cd6e8d831b21ae17fb6aabb.png").into(circleImageView);
        else if (getArguments().get("source").equals("CBC News")) Glide.with(getActivity())
                .load("https://www.cbc.ca/apple-touch-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("CBS News")) Glide.with(getActivity())
                .load("https://cbsnews4.cbsistatic.com/fly/bundles/cbsnewscore/icons/icon-128x128.png?v=1.764559b90627d43d03741a36ec5d9da29d5b5c98").into(circleImageView);
        else if (getArguments().get("source").equals("CNBC")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/C-120-fab715.png").into(circleImageView);
//        else if (getArguments().get("source").equals("CNN")) Glide.with(getActivity())
//                .load("https://cdn.cnn.com/cnn/.e/img/3.0/global/misc/apple-touch-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("CNN Spanish")) Glide.with(getActivity())
                .load("https://s2.wp.com/wp-content/themes/vip/cnnespanol/static/images/favicon/apple-touch-icon-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("Crypto Coins News")) Glide.with(getActivity())
                .load("https://www.ccn.com/wp-content/uploads/fbrfg/apple-touch-icon.png?v=yyLYg23").into(circleImageView);
        else if (getArguments().get("source").equals("Daily Mail")) Glide.with(getActivity())
                .load("https://www.dailymail.co.uk/apple-touch-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("Der Tagesspiegel")) Glide.with(getActivity())
                .load("https://www.tagesspiegel.de/images/apple-touch-icon/9800138/2-formatOriginal.png").into(circleImageView);
        else if (getArguments().get("source").equals("Die Zeit")) Glide.with(getActivity())
                .load("https://img.zeit.de/static/img/ZO-ipad-114x114.png").into(circleImageView);
        else if (getArguments().get("source").equals("El Mundo")) Glide.with(getActivity())
                .load("https://e00-elmundo.uecdn.es/apple-touch-icon-120x120-precomposed.png").into(circleImageView);
        else if (getArguments().get("source").equals("Engadget")) Glide.with(getActivity())
                .load("https://s.blogsmithmedia.com/www.engadget.com/assets-h67cadf3ed5f2d8164fd3f154e7919d13/images/apple-touch-icon-120x120.png?h=232a14b1a350de05a49b584a62abac9e").into(circleImageView);
        else if (getArguments().get("source").equals("Entertainment Weekly")) Glide.with(getActivity())
                .load("https://ew.com/img/favicons/favicon-120.png").into(circleImageView);
        else if (getArguments().get("source").equals("ESPN")) Glide.with(getActivity())
                .load("https://a.espncdn.com/wireless/mw5/r1/images/bookmark-icons-v2/espn-icon-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("ESPN Cric Info")) Glide.with(getActivity())
                .load("https://a.espncdn.com/wireless/mw5/r1/images/bookmark-icons/espncricinfo_icon-120x120.min.png").into(circleImageView);
        else if (getArguments().get("source").equals("Financial Post")) Glide.with(getActivity())
                .load("https://secure.gravatar.com/blavatar/b4ece3189893389a03f063830eacd95c?s=114").into(circleImageView);
        else if (getArguments().get("source").equals("Focus")) Glide.with(getActivity())
                .load("https://m.focus.de/apple-touch-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("Football Italia")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/F-120-9f0101.png").into(circleImageView);
        else if (getArguments().get("source").equals("Fortune")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/F-120.png").into(circleImageView);
        else if (getArguments().get("source").equals("FourFourTwo")) Glide.with(getActivity())
                .load("https://images.cdn.fourfourtwo.com/sites/fourfourtwo.com/themes/fourfourtwo/images/apple-icon-144x144px.png").into(circleImageView);
//        else if (getArguments().get("source").equals("Fox News")) Glide.with(getActivity())
//                .load("https://static.foxnews.com/static/orion/styles/img/fox-news/favicons/apple-touch-icon-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("Fox Sports")) Glide.with(getActivity())
                .load("https://b.fssta.com/sta/images/120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("Globo")) Glide.with(getActivity())
                .load("https://s.glbimg.com/en/ho/static/touchphone/img/apple-touch-icon-iphone-retina.png").into(circleImageView);
        else if (getArguments().get("source").equals("Google News")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/G-120-4285f4.png").into(circleImageView);
        else if (getArguments().get("source").equals("Google News (Argentina)")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/G-120-4285f4.png").into(circleImageView);
        else if (getArguments().get("source").equals("Google News (Australia)")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/G-120-4285f4.png").into(circleImageView);
        else if (getArguments().get("source").equals("Google News (Brasil)")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/G-120-4285f4.png").into(circleImageView);
        else if (getArguments().get("source").equals("Google News (Canada)")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/G-120-4285f4.png").into(circleImageView);
        else if (getArguments().get("source").equals("Google News (France)")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/G-120-4285f4.png").into(circleImageView);
        else if (getArguments().get("source").equals("Google News (India)")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/G-120-4285f4.png").into(circleImageView);
        else if (getArguments().get("source").equals("Google News (Israel)")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/G-120-4285f4.png").into(circleImageView);
        else if (getArguments().get("source").equals("Google News (Italy)")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/G-120-4285f4.png").into(circleImageView);
        else if (getArguments().get("source").equals("Google News (Russia)")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/G-120-4285f4.png").into(circleImageView);
        else if (getArguments().get("source").equals("Google News (Saudi Arabia)")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/G-120-4285f4.png").into(circleImageView);
        else if (getArguments().get("source").equals("Google News (UK)")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/G-120-4285f4.png").into(circleImageView);
        else if (getArguments().get("source").equals("Göteborgs-Posten")) Glide.with(getActivity())
                .load("https://www.gp.se/polopoly_fs/3.200.1562757435!/images/se.gp/apple-touch-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("Gruenderszene")) Glide.with(getActivity())
                .load("https://www.gruenderszene.de/bundles/gsglobal/images/apple/apple-icon-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("Hacker News")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/Y-120-ff6600.png").into(circleImageView);
        else if (getArguments().get("source").equals("Handelsblatt")) Glide.with(getActivity())
                .load("https://www.handelsblatt.com/images/apple-touch-icon/3896854/2-formatOriginal.png").into(circleImageView);
        else if (getArguments().get("source").equals("IGN")) Glide.with(getActivity())
                .load("https://m.ign.com/apple-touch-icon-precomposed.png").into(circleImageView);
        else if (getArguments().get("source").equals("Il Sole 24 Ore")) Glide.with(getActivity())
                .load("https://www.ilsole24ore.com/apple-touch-icon/apple-touch-icon-180x180.png").into(circleImageView);
        else if (getArguments().get("source").equals("Independent")) Glide.with(getActivity())
                .load("https://www.independent.co.uk/img/shortcut-icons/icon-72x72.png").into(circleImageView);
        else if (getArguments().get("source").equals("Infobae")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/I-120-f98900.png").into(circleImageView);
        else if (getArguments().get("source").equals("InfoMoney")) Glide.with(getActivity())
                .load("https://www.infomoney.com.br/assets/images/touch-icon-iphone-retina.png").into(circleImageView);
        else if (getArguments().get("source").equals("La Gaceta")) Glide.with(getActivity())
                .load("http://www.lagaceta.com.ar/apple-touch-icon-114x114-precomposed.png").into(circleImageView);
        else if (getArguments().get("source").equals("La Nacion")) Glide.with(getActivity())
                .load("https://www.lanacion.com.ar/apple-touch-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("La Repubblica")) Glide.with(getActivity())
                .load("https://www.repstatic.it/cless/main/nazionale/2016-v1/img/common/favicon/apple-touch-icon-120.png").into(circleImageView);
        else if (getArguments().get("source").equals("Le Monde")) Glide.with(getActivity())
                .load("https://www.lemonde.fr/dist/assets/img/logos/icon-120.png").into(circleImageView);
        else if (getArguments().get("source").equals("Lenta")) Glide.with(getActivity())
                .load("https://icdn.lenta.ru/lenta_touch.png").into(circleImageView);
        else if (getArguments().get("source").equals("L'equipe")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/L-120.png").into(circleImageView);
        else if (getArguments().get("source").equals("Les Echos")) Glide.with(getActivity())
                .load("https://static.lesechos.com/f6452c25ff0f26e6919f1ef0d83e3eb4.png").into(circleImageView);
        else if (getArguments().get("source").equals("Libération")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/L-120-e91845.png").into(circleImageView);
        else if (getArguments().get("source").equals("Marca")) Glide.with(getActivity())
                .load("https://e00-marca.uecdn.es/apple-touch-icon-120x120-precomposed.png").into(circleImageView);
        else if (getArguments().get("source").equals("Mashable")) Glide.with(getActivity())
                .load("https://mashable.com/apple-touch-icon-120x120.png?v=m2Pmw8zNwl").into(circleImageView);
        else if (getArguments().get("source").equals("Medical News Today")) Glide.with(getActivity())
                .load("https://cdn1.medicalnewstoday.com/favicon.png").into(circleImageView);
        else if (getArguments().get("source").equals("Metro")) Glide.with(getActivity())
                .load("https://metro.co.uk/wp-content/uploads/2018/05/m-icon-black.png?w=180").into(circleImageView);
        else if (getArguments().get("source").equals("Mirror")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/M-120.png").into(circleImageView);
        else if (getArguments().get("source").equals("MSNBC")) Glide.with(getActivity())
                .load("https://nodeassets.nbcnews.com/cdnassets/projects/ramen/favicon/msnbc/all-other-sizes-PNG.ico/apple-icon-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("MTV News")) Glide.with(getActivity())
                .load("http://www.mtv.com/apple-touch-icon-precomposed.png").into(circleImageView);
        else if (getArguments().get("source").equals("MTV News (UK)")) Glide.with(getActivity())
                .load("http://www.mtv.com/apple-touch-icon-precomposed.png").into(circleImageView);
        else if (getArguments().get("source").equals("National Geographic")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/N-120-ffce00.png").into(circleImageView);
        else if (getArguments().get("source").equals("National Review")) Glide.with(getActivity())
                .load("https://www.nationalreview.com/wp-content/themes/national-review/static/images/favicons/apple-icon-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("NBC News")) Glide.with(getActivity())
                .load("https://nodeassets.nbcnews.com/cdnassets/projects/ramen/favicon/nbcnews/all-other-sizes-PNG.ico/apple-icon-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("News24")) Glide.with(getActivity())
                .load("https://m.news24.com/favicon.ico").into(circleImageView);
        else if (getArguments().get("source").equals("New Scientist")) Glide.with(getActivity())
                .load("https://www.newscientist.com/wp-content/themes/new-scientist/img/layup/touch-icon/144x144.png").into(circleImageView);
        else if (getArguments().get("source").equals("News.com.au")) Glide.with(getActivity())
                .load("https://www.news.com.au/wp-content/themes/vip/newscorpau-nca/assets/dist/img/common/favicon/apple-touch-icon-180x180.png").into(circleImageView);
        else if (getArguments().get("source").equals("Newsweek")) Glide.with(getActivity())
                .load("https://g.newsweek.com/themes/newsweek/favicons/apple-touch-icon-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("New York Magazine")) Glide.with(getActivity())
                .load("http://assets.nymag.com/media/sites/nymag/icon.120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("Next Big Future")) Glide.with(getActivity())
                .load("https://www.nextbigfuture.com/wp-content/uploads/2017/04/ed85e288e0f5fe89658de9e9a0c1630c-150x150.png").into(circleImageView);
        else if (getArguments().get("source").equals("NFL News")) Glide.with(getActivity())
                .load("https://www.nfl.com/apple-touch-icon.png?akmobile=ios&akcarrier=other").into(circleImageView);
        else if (getArguments().get("source").equals("NHL News")) Glide.with(getActivity())
                .load("https://www-league.nhlstatic.com/nhl.com/builds/site-core/ea421e3a2e572b1bc003be8f238b4c6a505168fe_1562002460/images/iOS/apple-icon-144x144.png").into(circleImageView);
        else if (getArguments().get("source").equals("NRK")) Glide.with(getActivity())
                .load("https://www.nrk.no/assets/apple-touch-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("Politico")) Glide.with(getActivity())
                .load("https://static.politico.com/dims4/default/bd69088/2147483647/legacy_thumbnail/144x144/quality/90/?url=https%3A%2F%2Fstatic.politico.com%2Fcf%2F05%2Fee684a274496b04fa20ba2978da1%2Fpolitico.png").into(circleImageView);
        else if (getArguments().get("source").equals("Polygon")) Glide.with(getActivity())
                .load("https://cdn.vox-cdn.com/uploads/hub/sbnu_logo_minimal/405/touch_icon_ipad_retina_1000x1000.7014.png").into(circleImageView);
        else if (getArguments().get("source").equals("RBC")) Glide.with(getActivity())
                .load("https://s.rbk.ru/v10_rbcnews_static/common/common-10.1.81/images/apple-touch-icon-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("Recode")) Glide.with(getActivity())
                .load("https://cdn.vox-cdn.com/uploads/chorus_asset/file/6397047/recode_favicon-180.0.png").into(circleImageView);
        else if (getArguments().get("source").equals("Reddit /r/all")) Glide.with(getActivity())
                .load("https://www.redditstatic.com/mweb2x/favicon/120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("Reuters")) Glide.with(getActivity())
                .load("https://s1.reutersmedia.net/resources_v3/images/favicon/apple-touch-icon-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("RT")) Glide.with(getActivity())
                .load("https://russian.rt.com/static/blocks/touch-icon/apple-touch-icon-144x144-precomposed.png").into(circleImageView);
        else if (getArguments().get("source").equals("RTE")) Glide.with(getActivity())
                .load("https://www.rte.ie/apple-touch-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("RTL Nieuws")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/R-120-31a6d8.png").into(circleImageView);
        else if (getArguments().get("source").equals("SABQ")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/S-120-60c4fc.png").into(circleImageView);
        else if (getArguments().get("source").equals("Spiegel Online")) Glide.with(getActivity())
                .load("https://m.spiegel.de/static/V2/logo/favicon/touch-icon120.png").into(circleImageView);
        else if (getArguments().get("source").equals("Svenska Dagbladet")) Glide.with(getActivity())
                .load("https://static.svd.se/assets/assets/images/favicon/apple-touch-icon-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("T3n")) Glide.with(getActivity())
                .load("https://d1quwwdmdfumn6.cloudfront.net/t3n/2018/images/icons/t3n-apple-touch-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("TalkSport")) Glide.with(getActivity())
                .load("https://talksport.com/wp-content/uploads/sites/5/2018/06/cropped-App-Icon2.png?strip=all&w=180").into(circleImageView);
        else if (getArguments().get("source").equals("TechCrunch")) Glide.with(getActivity())
                .load("https://techcrunch.com/wp-content/uploads/2015/02/cropped-cropped-favicon-gradient.png?w=180").into(circleImageView);
        else if (getArguments().get("source").equals("TechCrunch (CN)")) Glide.with(getActivity())
                .load("https://cdn.techcrunch.cn/wp-content/themes/vip/techcrunch-cn-2014/assets/images/homescreen_TCIcon_ipad_2x.png").into(circleImageView);
        else if (getArguments().get("source").equals("TechRadar")) Glide.with(getActivity())
                .load("https://vanilla.futurecdn.net/techradar/122427/apple-touch-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("The American Conservative")) Glide.with(getActivity())
                .load("https://www.theamericanconservative.com/wp-content/themes/Starkers/images/touch-icon-144.png").into(circleImageView);
        else if (getArguments().get("source").equals("The Economist")) Glide.with(getActivity())
                .load("http://www.economist.com/assets/apple-touch-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("The Globe And Mail")) Glide.with(getActivity())
                .load("https://www.theglobeandmail.com/resources/assets/meta/apple-touch-icon-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("The Hill")) Glide.with(getActivity())
                .load("https://thehill.com/apple-touch-icon-120X120.png").into(circleImageView);
        else if (getArguments().get("source").equals("The Hindu")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/T-120-ffffff.png").into(circleImageView);
        else if (getArguments().get("source").equals("The Huffington Post")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/H-120-0dbc96.png").into(circleImageView);
        else if (getArguments().get("source").equals("The Irish Times")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/I-120.png").into(circleImageView);
        else if (getArguments().get("source").equals("The Jerusalem Post")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/J-120.png").into(circleImageView);
        else if (getArguments().get("source").equals("The Lad Bible")) Glide.with(getActivity())
                .load("http://www.ladbible.com/assets/images/theme/favicons/apple-touch-icon-120x120.png").into(circleImageView);
//        else if (getArguments().get("source").equals("The New York Times")) Glide.with(getActivity())
//                .load("https://www.nytimes.com/vi-assets/static-assets/apple-touch-icon-319373aaf4524d94d38aa599c56b8655.png").into(circleImageView);
        else if (getArguments().get("source").equals("The Next Web")) Glide.with(getActivity())
                .load("https://cdn0.tnwcdn.com/wp-content/themes/cyberdelia/assets/icons/apple-touch-icon-120x120.png?v=1563193225").into(circleImageView);
        else if (getArguments().get("source").equals("The Sport Bible")) Glide.with(getActivity())
                .load("http://www.sportbible.com/assets/images/theme/favicons/apple-touch-icon-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("The Telegraph")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/T-120-1a151b.png").into(circleImageView);
        else if (getArguments().get("source").equals("The Times of India")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/I-120-000000.png").into(circleImageView);
        else if (getArguments().get("source").equals("The Verge")) Glide.with(getActivity())
                .load("https://cdn.vox-cdn.com/uploads/chorus_asset/file/7395359/ios-icon.0.png").into(circleImageView);
        else if (getArguments().get("source").equals("The Wall Street Journal")) Glide.with(getActivity())
                .load("https://s.wsj.net/media/wsj_apple-touch-icon-120x120.png").into(circleImageView);
        else if (getArguments().get("source").equals("The Washington Post")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/W-120-000000.png").into(circleImageView);
        else if (getArguments().get("source").equals("The Washington Times")) Glide.with(getActivity())
                .load("https://twt-assets.washtimes.com/v4/images/icons/apple-touch-icon-precomposed.faa3cb2fc54e.png").into(circleImageView);
        else if (getArguments().get("source").equals("Time")) Glide.with(getActivity())
                .load("https://time.com/img/favicons/favicon-120.png").into(circleImageView);
        else if (getArguments().get("source").equals("USA Today")) Glide.with(getActivity())
                .load("https://www.gannett-cdn.com/gannett-web/properties/usatoday/logos-and-branding/logo-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("Vice News")) Glide.with(getActivity())
                .load("https://vice-news-statics-cdn.vice.com/static/images/favicon-128.png").into(circleImageView);
        else if (getArguments().get("source").equals("Wired")) Glide.with(getActivity())
                .load("https://www.wired.com/apple-touch-icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("Wired.de")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/W-120-daf400.png").into(circleImageView);
        else if (getArguments().get("source").equals("Wirtschafts Woche")) Glide.with(getActivity())
                .load("https://icon-locator.herokuapp.com/lettericons/W-120-e30613.png").into(circleImageView);
        else if (getArguments().get("source").equals("Xinhua Net")) Glide.with(getActivity())
                .load("http://www.xinhuanet.com/desk_icon.png").into(circleImageView);
        else if (getArguments().get("source").equals("Ynet")) Glide.with(getActivity())
                .load("https://m.ynet.co.il/content/images/icons/ios/apple-touch-icon-120x120.png").into(circleImageView);














































        return circleImageView;
    }

    public void getSourceUrl(){
    }

}

